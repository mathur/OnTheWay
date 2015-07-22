
package com.rmathur.food.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Venue {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Contact contact;
    @Expose
    private Location location;
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @Expose
    private boolean verified;
    @Expose
    private Stats stats;
    @Expose
    private String url;
    @Expose
    private Specials specials;
    @Expose
    private HereNow hereNow;
    @Expose
    private String storeId;
    @Expose
    private String referralId;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * @param contact
     *     The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * 
     * @return
     *     The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     * 
     * @param specials
     *     The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     * 
     * @return
     *     The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * 
     * @param hereNow
     *     The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    /**
     * 
     * @return
     *     The storeId
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 
     * @param storeId
     *     The storeId
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * 
     * @return
     *     The referralId
     */
    public String getReferralId() {
        return referralId;
    }

    /**
     * 
     * @param referralId
     *     The referralId
     */
    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

}
