angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8090/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
                $scope.getPages();
            });
    };

    $scope.getPages = function () {
        $http.get(contextPath + '/products/pages')
            .then(function (response) {
                $scope.Pages = response.data;
            });
    };

    $scope.toPage = function (page) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                page: page
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }


    $scope.loadProducts();
});