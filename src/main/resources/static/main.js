var app = angular.module("CakeManagement", []);

// Controller Part
app.controller("CakeController", function ($scope, $http) {


    $scope.Cakes = [];
    $scope.CakeForm = {
        title: "",
        desc: "",
        image: ""
    };

    // Now load the data from server
    _refreshCakeData();

    // HTTP POST methods for adding cake
    $scope.submitCake = function () {

        var method = "POST";
        var url = '/cakes';

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.CakeForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createCake = function () {
        _clearFormData();
    }


    // Private Method  
    // HTTP GET- get all Cakes collection
    // Call: http://localhost:8080/cakes
    function _refreshCakeData() {
        $http({
            method: 'GET',
            url: '/cakes'
        }).then(
            function (res) { // success
                $scope.Cakes = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
                alert("Error: " + status);
            }
        );
    }

    function _success(res) {
        _refreshCakeData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.CakeForm.desc = "";
        $scope.CakeForm.title = "";
        $scope.CakeForm.image = "";
    };
});