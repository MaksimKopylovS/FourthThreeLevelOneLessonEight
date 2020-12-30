angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.fillTable = function () {
        $http.get(contextPath + '/products/')
            .then(function (response) {
                ProductsList = response.data;
                $scope.ProductsList;
            });
    };
    $scope.fillTable();

    $scope.deleteProductById = function (id) {
        $http({
            url: contextPath + '/products/',
            method: 'GET',
            params: {
                productId: id
            }
        }).then(function (respone){
            console.log(respone)
            $scope.ProductsList = respone.data;
        });
    };
    $scope.deleteProductById();

    $scope.createNewProduct = function(){
        $http.post(contextPath +'/products', $scope.product)
            .then(function (response){
                console.log($scope.product);
                console.log(response.data);
                $scope.product = null;
                $scope.fillTable();
        });
    };
});