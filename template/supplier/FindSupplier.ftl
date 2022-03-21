<div class="screenlet-body">
  <div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">${uiLabelMap.FindSupplier}
        <span class="pull-right"><a class="btn  btn-primary p3" href="<@ofbizUrl>CreateSupplier</@ofbizUrl>">Create</a></span>
      </div>
      <div class="panel-body">
        <form id="FindSupplier" method="post" action="<@ofbizUrl>FindSupplier</@ofbizUrl>" class="form-horizontal">
          <div class="control-group">
            <label class="control-label" for="keyword"></label>
              <div class="controls">
                <input type="text" name="keyword" id="keyword" class='required' maxlength="50"/>
                <button type="submit" class="btn">${uiLabelMap.CommonFind}</button>
              </div>
          </div>
        </form>
      </div>
      <div class="panel-body">
        <#include "component://ofbizDemo/template/supplier/ListSupplier.ftl"/>
      </div>
    </div>
  </div>
</div>