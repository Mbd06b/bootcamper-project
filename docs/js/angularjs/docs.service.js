(function() {
'use strict';

angular
    .module('app')
    .service('DocsService', DocsService);

DocsService.$inject = ['$log', '$http'];

function DocsService($log, $http) {
	$log.info("Service Initialized");
	var DATA_URL = 'https://raw.githubusercontent.com/Mbd06b/bootcamper-project/main/docs/data/';
	return {
        getServiceMessage: function() {
          return $http.get(DATA_URL + 'message.json').then( 
			function (response) {
				return response.data; 
		  });
        }
   };	
}

})();