(function() {
'use strict';

angular
    .module('app')
    .controller('DocsController', DocsController);

DocsController.$inject = ['DocsService', '$log'];

function DocsController(DocsService, $log) { 
	var vm = this;
	$log.info('Controller Initalized');
	vm.serviceMessage = null;
	vm.controllerMessage = 'Controller is Working';
	
	vm.init = function(){
		vm.getServiceMessage();
	}
	
	vm.getServiceMessage = function (){
		DocsService.getServiceMessage()
		.then( function(data){
			vm.serviceMessage = data; 
		});
	}
		

	vm.init();
	
}

})();