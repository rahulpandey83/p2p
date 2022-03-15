<div class="screenlet-body">
  <div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">${uiLabelMap.FindSupplier}
        <span class="pull-right"><a class="btn  btn-primary p3" href="<@ofbizUrl>CreateSupplier</@ofbizUrl>">Create</a></span>
      </div>
      <div class="panel-body">
        <form id="FindSupplier" method="post" action="<@ofbizUrl>FindSupplier</@ofbizUrl>" class="form-horizontal">
          <div class="control-group">
            <label class="control-label" for="keywords"></label>
              <div class="controls">
                <input type="text" name="keywords" id="keywords" class='required' maxlength="20"/>
                <button type="submit" class="btn">${uiLabelMap.CommonFind}</button>
              </div>
          </div>
        </form>
      </div>
      <div class="panel-body">
        <#if supplierList?has_content>
        <table class="table table-bordered table-striped table-hover">
          <thead>
            <tr>
              <th>${uiLabelMap.PartyId}</th>
              <th>${uiLabelMap.SupplierName}</th>
              <th>${uiLabelMap.Phone}</th>
              <th>${uiLabelMap.Email}</th>
              <th>${uiLabelMap.Address}</th>
            </tr>
          </thead>
          <tbody>
            <#list supplierList as supplierList>
              <tr>
                <td><a href="<@ofbizUrl>ViewProfile</@ofbizUrl>?partyId=${supplierList.partyId!}">${supplierList.partyId!}</a></td>
                <td> ${supplierList.groupName!"-"}</td>
                <td> ${supplierList.contactNumber!"-"}</td>
                <td> ${supplierList.infoString!"-"}</td>
                <td> ${supplierList.address1!}${supplierList.address2!"-"}
                ${supplierList.city!"-"}
                ${supplierList.postalCode!"-"}
                ${supplierList.stateGeoName!"-"}
                ${supplierList.countryGeoName!"-"}</td>
              </tr>
            </#list>
          </tbody>
        </table>
      </#if>
    </div>
    </div>
  </div>
</div>