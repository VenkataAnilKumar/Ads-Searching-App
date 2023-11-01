package activity;

import datastore.AdsIndex;
import util.Ad;
import util.Campaign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Config.MIN_RESERVE_PRICE;

public class AdsCampaignManager {
    private static AdsCampaignManager instance = null;

    protected AdsCampaignManager() {
    }

    public static AdsCampaignManager getInstance() {
        if (instance == null) {
            instance = new AdsCampaignManager();
        }
        return instance;
    }

    public List<Ad> dedupeAdsByCampaignId(List<Ad> candidateAds) {
        Set<Long> hashSet = new HashSet<Long>();
        List<Ad> dedupedAds = new ArrayList<Ad>();

        for (Ad ad : candidateAds) {
            if (hashSet.add(ad.getCampaignId())) {
                dedupedAds.add(ad);
            }
        }
        return dedupedAds;
    }

    public List<Ad> applyBudget(List<Ad> candidateAds) {
        List<Ad> ads = new ArrayList<Ad>();

        for (int i = 0; i < candidateAds.size(); i++) {
            Ad ad = candidateAds.get(i);
            long campaignId = ad.getCampaignId();
            Campaign campaign = AdsIndex.getInstance().getCampaign(campaignId);
            if (campaign == null) {
                campaign = new Campaign();
                campaign.setBudget(60000);
            }
            double budget = campaign.getBudget();
            System.out.println("budget~~"+budget);
            if (ad.getCostPerClick() <= budget && ad.getCostPerClick() >= MIN_RESERVE_PRICE) {
                budget -= ad.getCostPerClick();
                campaign.setBudget(budget);
                AdsIndex.getInstance().setCampaign(campaign);
                ads.add(ad);
            }
        }
        return ads;
    }
}
