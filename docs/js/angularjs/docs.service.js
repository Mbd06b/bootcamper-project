(function() {
'use strict';

angular
    .module('app')
    .service('DocsService', DocsService);

DocsService.$inject = ['$log', '$http'];

function DocsService($log, $http) {
	$log.info("Service Initialized");
	
	return {
        getServiceMessage: function() {
          return $http.get('docs/data/message.json');
        }
   };	
}

})();