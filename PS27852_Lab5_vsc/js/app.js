var app = angular.module("myApp", []);

app.controller("MyCtrl2", function ($scope, $http) {
  const api = "http://localhost:8080/api/categories";
  $scope.categories = [];
  $scope.getData = function () {
    $http.get(api)
      .then(function (response) {
        $scope.categories = response.data.data;
        console.log($scope.categories);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.getDataById = function () {
    $http.get(api + "/1")
      .then(function (response) {
        $scope.categories = response.data.data;
        console.log($scope.categories);
        console.log(response.status);
      })
      .catch(function (error) {
        console.log(error);
        console.log(error.response.status);
      });
  };
  $scope.getDataById();
  $scope.getData();
});
app.controller("MyCtrl", function ($scope, $http) {
  const api = "http://localhost:8080/api/";
  $scope.students = [];
  $scope.email = "";
  $scope.student = {};
  $scope.getData = function () {
    $http
      .get(api + "students")
      .then(function (response) {
        $scope.students = response.data.data;
        console.log($scope.students);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.addStudent = function (student) {
    $http
      .post(api + "students", student)
      .then(function (response) {
        console.log(response);
        $scope.reset();
        $scope.getData();
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.deleteStudent = function (email) {
    $http
      .delete(api + "students/" + email + "")
      .then(function (response) {
        console.log(response);
        $scope.getData();
        console.log(email);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.editStudent = function (email) {
    $http
      .get(api + "students/" + email + "")
      .then(function (response) {
        $scope.student = response.data.data;
        $scope.email = email;
        console.log(response.data);
        console.log(email);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  $scope.updateStudent = function (student) {
    $http
      .put(api + "students", student)
      .then(function (response) {
        console.log(response);
        $scope.reset();
        $scope.getData();
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.reset = function () {
    $scope.student = {
      name: "",
      gender: true,
      email: "",
      marks: "",
      country: "VN",
    };
  };
  $scope.getData();
});
