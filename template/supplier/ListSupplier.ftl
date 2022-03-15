<div class="screenlet-body">
  <div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">${uiLabelMap.ListSupplier}</div>
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
                    <td><a href="<@ofbizUrl>CreateSupplier</@ofbizUrl>">${supplierList.partyId!}</a></td>
                    <td> ${supplierList.groupName?if_exists}</td>
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
</div>