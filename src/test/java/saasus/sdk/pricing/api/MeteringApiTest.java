/*
 * SaaSus Pricing API Schema
 * SaaSus Pricing API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.pricing.api;

import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.models.Error;
import saasus.sdk.pricing.models.MeteringUnit;
import saasus.sdk.pricing.models.MeteringUnitDateCount;
import saasus.sdk.pricing.models.MeteringUnitDateCounts;
import saasus.sdk.pricing.models.MeteringUnitDatePeriodCounts;
import saasus.sdk.pricing.models.MeteringUnitMonthCount;
import saasus.sdk.pricing.models.MeteringUnitMonthCounts;
import saasus.sdk.pricing.models.MeteringUnitProps;
import saasus.sdk.pricing.models.MeteringUnitTimestampCount;
import saasus.sdk.pricing.models.MeteringUnits;
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountNowParam;
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MeteringApi
 */
@Disabled
public class MeteringApiTest {

    private final MeteringApi api = new MeteringApi();

    /**
     * Create Metering Unit
     *
     * Create a metering unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createMeteringUnitTest() throws ApiException {
        MeteringUnitProps body = null;
        MeteringUnit response = api.createMeteringUnit(body);
        // TODO: test validations
    }

    /**
     * Delete Metering Unit
     *
     * Delete metering unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteMeteringUnitByIDTest() throws ApiException {
        String meteringUnitId = null;
        api.deleteMeteringUnitByID(meteringUnitId);
        // TODO: test validations
    }

    /**
     * Delete Metering Unit Count for Specified Timestamp
     *
     * Deletes metering unit count for the specified timestamp. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteMeteringUnitTimestampCountTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        Integer timestamp = null;
        api.deleteMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp);
        // TODO: test validations
    }

    /**
     * Get Metering Unit Count for Specific Date
     *
     * Gets the metering unit count for a specific date. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitDateCountByTenantIdAndUnitNameAndDateTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        String date = null;
        MeteringUnitDateCount response = api.getMeteringUnitDateCountByTenantIdAndUnitNameAndDate(tenantId, meteringUnitName, date);
        // TODO: test validations
    }

    /**
     * Obtain metering unit counts for a specified date/time period
     *
     * Obtain metering unit counts for a specified date/time period. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriodTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        Integer startTimestamp = null;
        Integer endTimestamp = null;
        MeteringUnitDatePeriodCounts response = api.getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod(tenantId, meteringUnitName, startTimestamp, endTimestamp);
        // TODO: test validations
    }

    /**
     * Get Metering Unit Count for the Current Day
     *
     * Get the metering unit count for the current day. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitDateCountByTenantIdAndUnitNameTodayTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        MeteringUnitDateCount response = api.getMeteringUnitDateCountByTenantIdAndUnitNameToday(tenantId, meteringUnitName);
        // TODO: test validations
    }

    /**
     * Get All Metering Unit Counts for a Specified Date
     *
     * Gets the total metering unit count for the specified date. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitDateCountsByTenantIdAndDateTest() throws ApiException {
        String tenantId = null;
        String date = null;
        MeteringUnitDateCounts response = api.getMeteringUnitDateCountsByTenantIdAndDate(tenantId, date);
        // TODO: test validations
    }

    /**
     * Get the Metering Unit Count for the Specified Month
     *
     * Gets the metering unit count for the specified month. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonthTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        String month = null;
        MeteringUnitMonthCount response = api.getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth(tenantId, meteringUnitName, month);
        // TODO: test validations
    }

    /**
     * Get Metering Unit Count for the Current Month
     *
     * Get the metering unit count for the current month. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonthTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        MeteringUnitMonthCount response = api.getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth(tenantId, meteringUnitName);
        // TODO: test validations
    }

    /**
     * Get All Metering Unit Counts for the Specified Month
     *
     * Gets all metering unit counts for the specified month. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitMonthCountsByTenantIdAndMonthTest() throws ApiException {
        String tenantId = null;
        String month = null;
        MeteringUnitMonthCounts response = api.getMeteringUnitMonthCountsByTenantIdAndMonth(tenantId, month);
        // TODO: test validations
    }

    /**
     * Get all metering units
     *
     * Get all metering units. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMeteringUnitsTest() throws ApiException {
        MeteringUnits response = api.getMeteringUnits();
        // TODO: test validations
    }

    /**
     * Update Metering Unit
     *
     * Update metering unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateMeteringUnitByIDTest() throws ApiException {
        String meteringUnitId = null;
        MeteringUnitProps body = null;
        api.updateMeteringUnitByID(meteringUnitId, body);
        // TODO: test validations
    }

    /**
     * Update Metering Unit Count for Specified Timestamp
     *
     * Update metering unit count for the specified timestamp. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateMeteringUnitTimestampCountTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        Integer timestamp = null;
        UpdateMeteringUnitTimestampCountParam updateMeteringUnitTimestampCountParam = null;
        MeteringUnitTimestampCount response = api.updateMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp, updateMeteringUnitTimestampCountParam);
        // TODO: test validations
    }

    /**
     * Update Metering Unit Count for Current Time
     *
     * Update the metering unit count for the current time. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateMeteringUnitTimestampCountNowTest() throws ApiException {
        String tenantId = null;
        String meteringUnitName = null;
        UpdateMeteringUnitTimestampCountNowParam updateMeteringUnitTimestampCountNowParam = null;
        MeteringUnitTimestampCount response = api.updateMeteringUnitTimestampCountNow(tenantId, meteringUnitName, updateMeteringUnitTimestampCountNowParam);
        // TODO: test validations
    }

}
