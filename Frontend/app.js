var app = angular.module('taskManager', ['ngMaterial']);

var varShowCompleted = true;

app.config(function ($httpProvider) {
  $httpProvider.defaults.headers.common = {};
  $httpProvider.defaults.headers.post = {};
  $httpProvider.defaults.headers.put = {};
  $httpProvider.defaults.headers.patch = {};
});

app.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('indigo')
    .accentPalette('pink');
  $mdThemingProvider.theme('altTheme1')
    .primaryPalette('blue')
    .accentPalette('green');

  $mdThemingProvider.alwaysWatchTheme(true);
});

app.controller('taskDisplayController', function($scope, $http, $mdToast, $window, $mdDialog, $mdTheming) {
	$scope.showCompleted = true;
    $http.get("http://localhost:8080/tasks")
    .then(function(response) {
    	console.log(response.data)
        $scope.tasks = response.data.taskList;
    });


    $scope.changeTheme = function() {
      $scope.dynamicTheme = $scope.theme;
      alert($scope.dynamicTheme);
    };


    function DialogController($scope, $mdDialog) {
    $scope.hide = function() {
      $mdDialog.hide();
    };

    $scope.cancel = function() {
      $mdDialog.cancel();
    };

    $scope.answer = function(answer) {
      $mdDialog.hide(answer);
    };
  }

    $scope.showAdvanced = function(ev) {
    $mdDialog.show({
      controller: DialogController,
      templateUrl: 'dialog1.tmpl.html',
      parent: angular.element(document.body),
      targetEvent: ev,
      clickOutsideToClose:true
    }).then(function() {

    });
    
  };

      $http.defaults.headers.post["Content-Type"] = "application/json";

  $scope.createTask =  function() {
  

    var newTaskDetails = JSON.stringify({
                taskName: $scope.taskName,
                taskClass: $scope.taskClass
            });
           // alert('hiii : ' + newTaskDetails);
           
    $http({
        url: 'http://localhost:8080/addUser',
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Accept": "application/json"
      },
        data:newTaskDetails 
      }).then(function(response) {
      //alert(response.data);
      $window.location.reload();
    });
  }

    $scope.completedTaskSelChange = function() {
        varShowCompleted = !varShowCompleted;
    };

    $scope.clearCompletedTasks = function() {
      
      $http.get("http://localhost:8080/clear")
     .then(function(response) {
        //alert(response.data);
        $window.location.reload();
     });
    };

    $scope.filterCompletedTasks = function(show) {

        return function(task) {
            if(task.status == 'COMPLETED' && varShowCompleted == false) {
                return false;
            } else {
                return true;
            }
        }
        
        
    };

    var last = {
      bottom: false,
      top: true,
      left: true,
      right: false
    };

    

  $scope.toastPosition = angular.extend({},last);

  $scope.getToastPosition = function() {
    return Object.keys($scope.toastPosition)
      .filter(function(pos) { return $scope.toastPosition[pos]; })
      .join(' ');
  };


    $scope.removeTask = function(task) {

        $http.get("http://localhost:8080/toggle?id=" + task.id)
        .then(function(response) {
             var pinTo = $scope.getToastPosition();
//             alert(pinTo);
            if(response.data == 1) {
                task.status = 'COMPLETED';
                $mdToast.show({
                  hideDelay:5000, 
                  position : 'top right',
                  controller : 'ToastCtrl',
                  templateUrl : 'toast-template.html'
                });
            }

        });
    };
})
  .controller('ToastCtrl', function($scope, $mdToast) {

    var isDlgOpen;

    $scope.closeToast = function() {
      if(isDlgOpen) return;

      $mdToast
        .hide()
        .then(function() {
          isDlgOpen = false;
        });
    };
  });

angular.module('insertManager', []).controller('taskCreationController', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/json";

	$scope.createTask =  function() {
	

		var newTaskDetails = JSON.stringify({
                taskName: $scope.taskName,
                taskClass: $scope.taskClass
            });
           // alert('hiii : ' + newTaskDetails);
           
		$http({
        url: 'http://localhost:8080/addUser',
        method: "POST",
        headers: {
        	"Content-Type": "application/json",
        	"Accept": "application/json"
    	},
        data:newTaskDetails 
    	}).then(function(response) {
			alert(response.data);
		});
	}
});

/*
app.controller('taskDeletionController', function($scope, $http) {

	$scope.deleteTask = function() {
		$http.get("http://localhost:8080/delete")
	    .then(function(response) {
	    	console.log(response.data)
	    });
	}
});*/

function changeValue() {
	document.getElementById('{{task.name}}').innerHTML = "COMPLETED";
}
