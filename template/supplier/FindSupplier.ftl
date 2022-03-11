<div class="screenlet-body">
  <div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">${uiLabelMap.FindSupplier}
        <span class="pull-right"><a class="btn btn-success p3" href="<@ofbizUrl>CreateSupplier</@ofbizUrl>">Create</a></span>
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
    </div>
  </div>
</div>