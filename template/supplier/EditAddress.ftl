<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.EditAddress}</div>
    <div class="panel-body">
      <form id="EditSupplierAddress" method="post" action="<@ofbizUrl>EditSupplierAddress</@ofbizUrl>" class="form-horizontal">
        <#if supplierList?has_content>
          <#list supplierList as supplierList>
            <div class="form-group row">
              <label for="address1" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress1}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="address1" name="address1" value="${supplierList.address1!}">
                <input type="hidden" id="contactMechId" name="contactMechId" value=${supplierList.addressContactId!}>
              </div>
            </div>
            <div class="form-group row">
              <label for="address2" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress2}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="address2" name="address2" value="${supplierList.address2!}">
              </div>
            </div>
            <div class="form-group row">
              <label for="city" class="col-sm-1 col-form-label">${uiLabelMap.CommonCity}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="city" name="city" value="${supplierList.city!}">
              </div>
            </div>
            <div class="form-group row">
              <label for="postalCode" class="col-sm-1 col-form-label">${uiLabelMap.CommonZipPostalCode}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="postalCode" name="postalCode" value="${supplierList.postalCode!}">
              </div>
            </div>
            <div class="form-group row">
              <label for="stateProvinceGeoId" class="col-sm-1 col-form-label">${uiLabelMap.CommonState}</label>
              <div class="col-sm-6">
                <select  class="col-sm-12" id="stateProvinceGeoId" name="stateProvinceGeoId">
                  <#list states as stateType>
                    <option value='${stateType.geoId}'>${stateType.geoName}</option>
                  </#list>
                </select>
              </div>
            </div>
            <div class="form-group row">
              <label for="countryGeoId" class="col-sm-1 col-form-label">${uiLabelMap.CommonCountry}</label>
              <div class="col-sm-6">
                <select  class="col-sm-12 " id="countryGeoId" name="countryGeoId">
                  <#list countries as countryType>
                    <option  value='${countryType.geoId}'>${countryType.geoName}</option>
                  </#list>
                </select>
              </div>
            </div>
            <input type="hidden" id="partyId" name="partyId" value=${supplierList.partyId!}>
          </#list>
        </#if>
        <div class="form-group row ">
          <div class="col-sm-6 pull-right">
            <button type="submit" class="btn btn-primary">${uiLabelMap.CommonUpdate}</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
