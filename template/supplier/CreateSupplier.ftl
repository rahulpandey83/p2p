<div class="screenlet-body">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.CreateSupplier}</div>
    <div class="panel-body">
      <form id="createSupplier" method="post" action="<@ofbizUrl>createSupplier</@ofbizUrl>" class="form-horizontal">
        <div class="form-group row">
          <label for="groupName" class="col-sm-1 col-form-label">${uiLabelMap.SupplierName}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="groupName" name="groupName" placeholder="group Name" maxlength="50">
          </div>
        </div>
        <div class="form-group row">
          <label for="contactNumber" class="col-sm-1 col-form-label">${uiLabelMap.Phone}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="contactNumber" name="contactNumber" placeholder="contact Number" maxlength="10">
          </div>
        </div>
        <div class="form-group row">
          <label for="emailAddress" class="col-sm-1 col-form-label">${uiLabelMap.CommonEmail}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="emailAddress" name="emailAddress" placeholder="email Address" maxlength="50">
          </div>
        </div>
        <div class="form-group row">
          <label for="address1" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress1}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="address1" name="address1" placeholder="address Line 1" maxlength="100">
          </div>
        </div>
        <div class="form-group row">
          <label for="address2" class="col-sm-1 col-form-label">${uiLabelMap.CommonAddress2}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="address2" name="address2" placeholder="address Line 2" maxlength="100">
          </div>
        </div>
        <div class="form-group row">
          <label for="city" class="col-sm-1 col-form-label">${uiLabelMap.CommonCity}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="city"  name="city" placeholder="city" maxlength="20">
          </div>
        </div>
        <div class="form-group row">
          <label for="postalCode" class="col-sm-1 col-form-label">${uiLabelMap.CommonZipPostalCode}</label>
          <div class="col-sm-6">
            <input type="text" class="form-control" id="postalCode"  name="postalCode" placeholder="postal Code" maxlength="10">
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
              <option value='${countryType.geoId}'>${countryType.geoName}</option>
            </#list>
            </select>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6">
            <button type="submit" class="btn btn-primary">${uiLabelMap.CommonCreate}</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
