/*!
 * Remark (http://getbootstrapadmin.com/remark)
 * Copyright 2015 amazingsurge
 * Licensed under the Themeforest Standard Licenses
 */


(function(document, window, $) {
  'use strict';


  // Example Bootstrap Table Events
  // ------------------------------
  (function() {
    $('#student').bootstrapTable({
      url: "data/student_data.json",
      search: true,
      pagination: true,
      showRefresh: true,
      showToggle: true,
        showExport:true,
      showColumns: true,
      iconSize: 'outline',
      toolbar: '#student_toolbar',
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      }
    });

  })();
})(document, window, jQuery);
