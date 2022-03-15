<div class="screenlet-body" xmlns="http://www.w3.org/1999/html">
  <div class="panel panel-default">
    <div class="panel-heading">${uiLabelMap.EditProfile}</div>
    <div class="panel-body">
      <form id="EditSupplierProfile" method="post" action="<@ofbizUrl>EditSupplierProfile</@ofbizUrl>" class="form-horizontal">
        <#if supplierList?has_content>
          <#list supplierList as supplierList>
            <div class="form-group row">
              <label for="groupName" class="col-sm-1 col-form-label">${uiLabelMap.CommonName}</label>
                <div class="col-sm-11">
                  <input type="text" class="form-control" id="groupName" name="groupName" value=${supplierList.groupName!}>
                </div>
            </div>
            <div class="form-group row">
              <label for="contactNumber" class="col-sm-1 col-form-label">${uiLabelMap.Phone}</label>
              <div class="col-sm-11">
                <input type="text" class="form-control" id="contactNumber" name="contactNumber" value=${supplierList.contactNumber!}>
                <input type="hidden" id="phoneContactMechId" name="phoneContactMechId" value=${supplierList.numberContactId!}>
              </div>
            </div>
            <div class="form-group row">
              <label for="emailAddress" class="col-sm-1 col-form-label">${uiLabelMap.CommonEmail}</label>
              <div class="col-sm-11">
                <input type="text" class="form-control" id="emailAddress" name="emailAddress" value=${supplierList.infoString!}>
                <input type="hidden" id="emailContactMechId" name="emailContactMechId" value=${supplierList.emailContactId!}>
              </div>
            </div>
            <div>
              <input type="hidden" id="partyId" name="partyId" value=${supplierList.partyId!}>
            </div>
          </#list>
        </#if>
        <div class="form-group row pull-right">
          <div class="col-sm-11 ">
            <button type="submit" class="btn btn-primary">${uiLabelMap.CommonUpdate}</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
