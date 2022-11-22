package com.fypRest.repository;

import com.fypRest.DTO.CustomDonation;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomDonationRepository {

    private final EntityManager entityManager;

    public CustomDonationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CustomDonation> findAllDonationById(int id, String user) {

        String filter = user.equals("donor") ? "donner_id" : "charity_house_id";
        try {
            Query nativeQuery = entityManager.createNativeQuery(
                    "SELECT fdd.id, fdd.quantity_value, fdd.quantity_unit, " +
                        " fi.name, fi.expiry_date, fi.type, fi.image, " +
                        " d.date, d.donner_id, d.charity_house_id, d.status, d.acceptance_time " +
                        " FROM charityDB.food_donation_details fdd " +
                        " left outer join food_item fi on fdd.food_item_id = fi.id " +
                        " left outer join donation d on fdd.donation_id = d.id " +
                        " where " + filter + " = ?1");
            nativeQuery.setParameter(1, id);
            List<CustomDonation> donations = mapToCustomDonationList((List<Object[]>) nativeQuery.getResultList());

            nativeQuery = entityManager.createNativeQuery(
                    "SELECT fd.id, fd.amount, fd.currency, fd.donner_card, " +
                       " d.date, d.donner_id, d.charity_house_id, d.status, d.acceptance_time " +
                       " FROM charityDB.fund_donation fd " +
                       " left outer join donation d on fd._donation_id = d.id " +
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
            customDonations.add(customDonation);
        }
        return customDonations;
    }
}
