var app = angular.module("myApp", []);
app.controller("MyCtrl", function ($scope, $http) {
  const api = "https://ps27852lab4-default-rtdb.firebaseio.com/";
  $scope.students = [];
  $scope.key = "";
  $scope.getData = function () {
    $http
      .get(api + "students.json")
      .then(function (response) {
        $scope.students = response.data;
        console.log($scope.students);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.addStudent = function (student) {
    $http
      .post(api + "students.json", student)
      .then(function (response) {
        console.log(response);
        $scope.reset();
        $scope.getData();
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.deleteStudent = function (key) {
    $http
      .delete(api + "students/" + key + ".json")
      .then(function (response) {
        console.log(response);
        $scope.getData();
        console.log(key);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.editStudent = function (key) {
    $http
      .get(api + "students/" + key + ".json")
      .then(function (response) {
        $scope.student = response.data;
        $scope.key = key;
        console.log(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  $scope.updateStudent = function (student) {
    $http
      .put(api + "students/" + $scope.key + ".json", student)
      .then(function (response) {
        console.log(response);
        $scope.getData();
        $scope.reset();
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
