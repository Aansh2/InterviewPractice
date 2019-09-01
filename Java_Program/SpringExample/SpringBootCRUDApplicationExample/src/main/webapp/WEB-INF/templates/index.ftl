<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="static/css/bootstrap.css" rel="stylesheet"/>
        <link href="static/css/app.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        <script src="static/js/lib/angular.min.js" ></script>
        <script src="static/js/lib/angular-ui-router.min.js" ></script>
        <script src="static/js/lib/localforage.min.js" ></script>
        <script src="static/js/lib/ngStorage.min.js"></script>
        <script src="static/js/app/app.js"></script>
        <script src="static/js/app/UserService.js"></script>
        <script src="static/js/app/UserController.js"></script>
    </body>
</html>