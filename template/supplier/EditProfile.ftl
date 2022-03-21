<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.EditProfile}</div>
    <div class="panel-body">
      <#if supplierInfo?has_content>
        <#assign supplierInfo = supplierInfo/>
          <form id="updateSupplierDetail" method="post" action="<@ofbizUrl>updateSupplierDetail</@ofbizUrl>" class="form-horizontal">
            <input type="hidden" id="partyId" name="partyId" value=${supplierInfo.partyId!}>
            <div class="form-group row">
              <label for="groupName" class="col-sm-1 col-form-label">${uiLabelMap.CommonName}</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control" id="groupName" name="groupName" value="${supplierInfo.groupName!}">
                </div>
            </div>
            <div class="form-group row">
              <label for="contactNumber" class="col-sm-1 col-form-label">${uiLabelMap.Phone}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="contactNumber" name="contactNumber" value="${supplierInfo.contactNumber!}">
                <input type="hidden" id="phoneContactMechId" name="phoneContactMechId" value=${supplierInfo.numberContactId!}>
              </div>
            </div>
            <div class="form-group row">
              <label for="emailAddress" class="col-sm-1 col-form-label">${uiLabelMap.CommonEmail}</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" id="emailAddress" name="emailAddress" value="${supplierInfo.infoString!}">
                <input type="hidden" id="emailContactMechId" name="emailContactMechId" value=${supplierInfo.emailContactId!}>
              </div>
            </div>
            <div class="form-group row ">
              <div class="col-sm-6 pull-right">
                <button type="submit" class="btn btn-primary">${uiLabelMap.CommonUpdate}</button>
              </div>
            </div>
          </form>
      </#if>
    </div>
  </div>
</div>
