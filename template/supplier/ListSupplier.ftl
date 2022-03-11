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
                  <th>${uiLabelMap.GroupName}</th>
                  <th>${uiLabelMap.Phone}</th>
                  <th>${uiLabelMap.Email}</th>
                  <th>${uiLabelMap.Address}</th>
                </tr>
              </thead>
              <tbody>
                <#list supplierList as supplierList>
                  <tr>
                    <td> ${supplierList.partyId!}</td>
                    <td> ${supplierList.groupName?if_exists}</td>
                    <td> ${supplierList.contactNumber!"-"}</td>
                    <td> ${supplierList.infoString?if_exists}</td>
                    <td> ${supplierList.address1?if_exists},${supplierList.address2?if_exists},
                    ${supplierList.city?if_exists}
                    ,${supplierList.postalCode?if_exists}
                    ,${supplierList.stateGeoName?if_exists}
                    ,${supplierList.countryGeoName?if_exists}</td>
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