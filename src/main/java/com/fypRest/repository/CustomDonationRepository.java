package com.fypRest.repository;

import com.fypRest.DTO.CustomDonation;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomDonationRepository {

    private final EntityManager entityManager;

    public CustomDonationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public boolean updateDonationByID(int id, String status, String time) {
        try {
            Query nativeQuery = entityManager.createNativeQuery(
                    "update donation set status = ?1, acceptance_time = ?2 where id= ?3");
            nativeQuery.setParameter(1, status);
            nativeQuery.setParameter(2, time);
            nativeQuery.setParameter(3, id);
            nativeQuery.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<CustomDonation> findAllDonationById(int id, String user) {

        String filter = user.equals("donor") ? "donner_id" : "charity_house_id";
        try {
            Query nativeQuery = entityManager.createNativeQuery(
                    "SELECT d.id, fdd.quantity_value, fdd.quantity_unit, " +
                            " fi.name, fi.expiry_date, fi.type, fi.image, " +
                            " d.date, d.donner_id, d.charity_house_id, d.status, d.acceptance_time, " +
                            " u.email as from_email, u.first_name as from_first_name, u.last_name as from_last_name, " +
                            " ch.name as to_name, ch.email as to_email " +
                            " FROM charityDB.food_donation_details fdd " +
                            " left outer join food_item fi on fdd.food_item_id = fi.id " +
                            " left outer join donation d on fdd.donation_id = d.id " +
                            " left outer join donner dd on d.donner_id = dd.id " +
                            " left outer join user u on dd._user_id = u.id " +
                            " left outer join charity_house ch on d.charity_house_id = ch.id" +
                            " where " + filter + " = ?1");
            nativeQuery.setParameter(1, id);
            List<CustomDonation> donations = mapToCustomDonationList((List<Object[]>) nativeQuery.getResultList());

            nativeQuery = entityManager.createNativeQuery(
                    "SELECT d.id, fd.amount, fd.currency, fd.donner_card, " +
                            " d.date, d.donner_id, d.charity_house_id, d.status, d.acceptance_time, " +
                            " u.email as from_email, u.first_name as from_first_name, u.last_name as from_last_name, " +
                            " ch.name as to_name, ch.email as to_email " +
                            " FROM charityDB.fund_donation fd " +
                            " left outer join donation d on fd._donation_id = d.id " +
                            " left outer join donner dd on d.donner_id = dd.id " +
                            " left outer join user u on dd._user_id = u.id " +
                            " left outer join charity_house ch on d.charity_house_id = ch.id " +
                            " where " + filter + " = ?1");
            nativeQuery.setParameter(1, id);

            List<CustomDonation> funDDonations = mapToCustomFundDonationList((List<Object[]>) nativeQuery.getResultList());
            donations.addAll(funDDonations);

            return donations;
        } catch (Exception e) {
            throw e;
        }
    }

    private List<CustomDonation> mapToCustomFundDonationList(List<Object[]> resultList) {
        List<CustomDonation> customDonations = new ArrayList<>();

        for (Object[] row : resultList) {
            CustomDonation customDonation = new CustomDonation();
            customDonation.setDonationType("fund");
            customDonation.setId((Integer) row[0]);
            customDonation.setAmount((Integer) row[1]);
            customDonation.setCurrency((String) row[2]);
            customDonation.setDonorCard((String) row[3]);
            customDonation.setDate((Date) row[4]);
            customDonation.setDonorId((Integer) row[5]);
            customDonation.setCharityHouseId((Integer) row[6]);
            customDonation.setStatus((String) row[7]);
            customDonation.setAcceptanceTime((String) row[8]);
            customDonation.setFromEmail((String) row[9]);
            customDonation.setFromFirstName((String) row[10]);
            customDonation.setFromLastName((String) row[11]);
            customDonation.setToName((String) row[12]);
            customDonation.setToEmail((String) row[13]);
            customDonations.add(customDonation);
        }
        return customDonations;
    }

    private List<CustomDonation> mapToCustomDonationList(List<Object[]> resultList) {
        List<CustomDonation> customDonations = new ArrayList<>();

        for (Object[] row : resultList) {
            CustomDonation customDonation = new CustomDonation();
            customDonation.setDonationType("food");
            customDonation.setId((Integer) row[0]);
            customDonation.setQuantityValue((Integer) row[1]);
            customDonation.setQuantityUnit((String) row[2]);
            customDonation.setFoodName((String) row[3]);
            customDonation.setExpiryDate((Date) row[4]);
            customDonation.setFoodType((String) row[5]);
            customDonation.setFoodImage((String) row[6]);
            customDonation.setDate((Date) row[7]);
            customDonation.setDonorId((Integer) row[8]);
            customDonation.setCharityHouseId((Integer) row[9]);
            customDonation.setStatus((String) row[10]);
            customDonation.setAcceptanceTime((String) row[11]);
            customDonation.setFromEmail((String) row[12]);
            customDonation.setFromFirstName((String) row[13]);
            customDonation.setFromLastName((String) row[14]);
            customDonation.setToName((String) row[15]);
            customDonation.setToEmail((String) row[16]);
            customDonations.add(customDonation);
        }
        return customDonations;
    }
}
