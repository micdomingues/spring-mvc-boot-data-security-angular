wimb.factory('restService', ['$http, $location', function($http, $location){
    
    var repository = $location.path();
    
    return {
        save : function(entity){
            return $http({url: repository , method:'POST' , params : entity})
        },
        
        list : function(){
            return $http({url: repository , method:'GET'})
        },
        
        getOne : function(){
            
        }
    }
    
    
    
    
    return null;
    
}]);


 $http({url:'usuario/create', method:'POST' , params : p}).success(function(data) {
          console.log(JSON.stringify(data));
            }).error(function(data) {
              console.log(data)
            });