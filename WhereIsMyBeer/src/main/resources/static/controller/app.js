angular.module('hello', [ 'ngRoute' ])
  .config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home'
	}).when('/login', {
      		templateUrl : 'login.html',
      		controller : 'navigation'
    }).when('/usuario', {
            templateUrl : 'usuario.html',
            controller : 'user'
        }).otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  })
  .controller('home', function($scope, $http) {
    $http.get('usuario/resource/').success(function(data) {
      $scope.greeting = data;
    })
  })

.controller('user', function($scope, $http) {
    $scope.user = {};
     $scope.createUser = function(newUser) {
        var p = {
            email: newUser.email,
            nome: newUser.nome
        };
         console.log(p);
        $http({url:'usuario/create', method:'POST' , params : p}).success(function(data) {
          console.log(JSON.stringify(data));
            }).error(function(data) {
              console.log(data)
            });
          }
})
.controller('navigation',

      function($rootScope, $scope, $http, $location) {

      var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        console.log(headers);

        $http.get('usuario/user', {headers : headers}).success(function(data) {
          if (data.name) {
            console.log(data);

            $rootScope.authenticated = true;
          } else {
            $rootScope.authenticated = false;
          }
          callback && callback();
        }).error(function() {
          $rootScope.authenticated = false;
          callback && callback();
        });

      }

      authenticate();
      $scope.credentials = {};

      $scope.login = function() {
          authenticate($scope.credentials, function() {
            if ($rootScope.authenticated) {
              $location.path("/");
              $scope.error = false;
            } else {
              console.log("eeerrou");
              $scope.error = true;
            }
          });
      };

    $scope.logout = function() {
      $http.post('usuario/logout', {}).success(function() {
        $rootScope.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        $rootScope.authenticated = false;
      });
    }

});