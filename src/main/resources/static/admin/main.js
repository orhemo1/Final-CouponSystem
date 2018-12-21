(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".myButton {\r\n\r\n\tfilter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#768d87', endColorstr='#6c7c7c',GradientType=0);\r\n\tbackground-color:#a4a8a7;\r\n\tborder-radius:11px;\r\n\t\r\n\tdisplay:inline-block;\r\n\tcursor:pointer;\r\n\tcolor:#ffffff;\r\n\tfont-family:Arial;\r\n\tfont-size:16px;\r\n\tfont-weight:bold;\r\n\tpadding:10px 15px 10px 15px;\r\n\ttext-decoration:none;\r\n\tfloat: right;\r\n\tmargin-top: 4px;\r\n}\r\n.myButton:hover {\r\n\tfilter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6c7c7c', endColorstr='#768d87',GradientType=0);\r\n\tbackground-color:#6c7c7c;\r\n}\r\n.myButton:active {\r\n\tposition:relative;\r\n\ttop:1px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n<div id=\"custom-bootstrap-menu\" class=\"navbar navbar-default \" role=\"navigation\">\r\n<div class=\"container-fluid\">\r\n    <div class=\"navbar-header\"><a class=\"navbar-brand\"  style=\"font-size: 23px;font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;\">Admin Facade</a>\r\n      \r\n    </div>\r\n    <div class=\"collapse navbar-collapse navbar-menubuilder\" style=\"font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;\">\r\n        <ul class=\"nav navbar-nav navbar-left\">\r\n            <li><a routerLink=\"/createcompany\">Create Company</a>\r\n            </li>\r\n            <li><a  routerLink=\"/getcompany\">Get Company</a>\r\n            </li>\r\n            <li><a routerLink=\"/getallcompanies\">Get All Companies</a>\r\n            </li>\r\n            <li><a routerLink=\"/createcustomer\">Create Customer</a>\r\n            </li>\r\n            <li><a routerLink=\"/getcustomer\">Get Customer</a>\r\n            </li>\r\n             <li><a routerLink=\"/getallcustomers\">GET All Customers</a>\r\n            </li>\r\n            <li></li>\r\n        </ul>\r\n        <a (click)=\"logOut()\"  class=\"myButton\" href=\"http://localhost:8080\">Log-out</a>\r\n    </div>\r\n</div>\r\n</div>\r\n\r\n<router-outlet></router-outlet>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(_services) {
        this._services = _services;
        this.title = 'admin-web-api';
    }
    AppComponent.prototype.logOut = function () {
        this._services.logOut().subscribe(function (resp) {
            console.log(resp);
        });
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_1__["AppServicesService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _componennts_create_company_create_company_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./componennts/create-company/create-company.component */ "./src/app/componennts/create-company/create-company.component.ts");
/* harmony import */ var _componennts_get_company_get_company_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./componennts/get-company/get-company.component */ "./src/app/componennts/get-company/get-company.component.ts");
/* harmony import */ var _componennts_get_all_companies_get_all_companies_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./componennts/get-all-companies/get-all-companies.component */ "./src/app/componennts/get-all-companies/get-all-companies.component.ts");
/* harmony import */ var _componennts_creat_customer_creat_customer_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./componennts/creat-customer/creat-customer.component */ "./src/app/componennts/creat-customer/creat-customer.component.ts");
/* harmony import */ var _componennts_get_customer_get_customer_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./componennts/get-customer/get-customer.component */ "./src/app/componennts/get-customer/get-customer.component.ts");
/* harmony import */ var _componennts_get_all_customers_get_all_customers_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./componennts/get-all-customers/get-all-customers.component */ "./src/app/componennts/get-all-customers/get-all-customers.component.ts");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./../services/app-services.service */ "./src/services/app-services.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                _componennts_create_company_create_company_component__WEBPACK_IMPORTED_MODULE_6__["CreateCompanyComponent"],
                _componennts_get_company_get_company_component__WEBPACK_IMPORTED_MODULE_7__["GetCompanyComponent"],
                _componennts_get_all_companies_get_all_companies_component__WEBPACK_IMPORTED_MODULE_8__["GetAllCompaniesComponent"],
                _componennts_creat_customer_creat_customer_component__WEBPACK_IMPORTED_MODULE_9__["CreatCustomerComponent"],
                _componennts_get_customer_get_customer_component__WEBPACK_IMPORTED_MODULE_10__["GetCustomerComponent"],
                _componennts_get_all_customers_get_all_customers_component__WEBPACK_IMPORTED_MODULE_11__["GetAllCustomersComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_5__["HttpModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"].forRoot([
                    {
                        path: 'createcompany',
                        component: _componennts_create_company_create_company_component__WEBPACK_IMPORTED_MODULE_6__["CreateCompanyComponent"],
                    },
                    {
                        path: 'getcompany',
                        component: _componennts_get_company_get_company_component__WEBPACK_IMPORTED_MODULE_7__["GetCompanyComponent"],
                    }, {
                        path: 'getallcompanies',
                        component: _componennts_get_all_companies_get_all_companies_component__WEBPACK_IMPORTED_MODULE_8__["GetAllCompaniesComponent"],
                    }, {
                        path: 'createcustomer',
                        component: _componennts_creat_customer_creat_customer_component__WEBPACK_IMPORTED_MODULE_9__["CreatCustomerComponent"],
                    },
                    {
                        path: 'getcustomer',
                        component: _componennts_get_customer_get_customer_component__WEBPACK_IMPORTED_MODULE_10__["GetCustomerComponent"],
                    },
                    {
                        path: 'getallcustomers',
                        component: _componennts_get_all_customers_get_all_customers_component__WEBPACK_IMPORTED_MODULE_11__["GetAllCustomersComponent"],
                    }
                ])
            ],
            providers: [_services_app_services_service__WEBPACK_IMPORTED_MODULE_12__["AppServicesService"], { provide: _angular_common__WEBPACK_IMPORTED_MODULE_13__["LocationStrategy"], useClass: _angular_common__WEBPACK_IMPORTED_MODULE_13__["HashLocationStrategy"] }],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/common/company.ts":
/*!***********************************!*\
  !*** ./src/app/common/company.ts ***!
  \***********************************/
/*! exports provided: Company */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Company", function() { return Company; });
var Company = /** @class */ (function () {
    function Company(jsonid, jsonname, jsonpassword, jsonemail) {
        this.jsonid = jsonid;
        this.jsonname = jsonname;
        this.jsonpassword = jsonpassword;
        this.jsonemail = jsonemail;
        this.id = jsonid;
        this.name = jsonname;
        this.password = jsonpassword;
        this.email = jsonemail;
    }
    return Company;
}());



/***/ }),

/***/ "./src/app/common/customer.ts":
/*!************************************!*\
  !*** ./src/app/common/customer.ts ***!
  \************************************/
/*! exports provided: Customer */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Customer", function() { return Customer; });
var Customer = /** @class */ (function () {
    function Customer(userid, username, userpassword) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.id = userid;
        this.name = username;
        this.password = userpassword;
    }
    return Customer;
}());



/***/ }),

/***/ "./src/app/componennts/creat-customer/creat-customer.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/componennts/creat-customer/creat-customer.component.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/creat-customer/creat-customer.component.html":
/*!**************************************************************************!*\
  !*** ./src/app/componennts/creat-customer/creat-customer.component.html ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<h2 style=\"font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif\">NEW CUSTOMER:</h2>\n<div style=\"width: 250px;\"> \n<label for=\"inputEmail4\">&nbsp;NAME : &nbsp;</label> \n<input type=\"text\"  class=\"form-control\"  name=\"nametxt\" placeholder=\"insert customer name\" [(ngModel)]=\"customerAdd.name\"><br>\n\n<label for=\"inputEmail4\">&nbsp;PASSWORD : &nbsp;</label> \n<input type=\"password\"  class=\"form-control\"  name=\"passwordtxt\" placeholder=\"insert customer password\" [(ngModel)]=\"customerAdd.password\"><br>\n</div>\n<button (click)=\"addCustomer()\" >ADD CUSTOMER</button><br>\n\n<br>\n<br>\n"

/***/ }),

/***/ "./src/app/componennts/creat-customer/creat-customer.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/componennts/creat-customer/creat-customer.component.ts ***!
  \************************************************************************/
/*! exports provided: CreatCustomerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreatCustomerComponent", function() { return CreatCustomerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_common_customer__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/common/customer */ "./src/app/common/customer.ts");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CreatCustomerComponent = /** @class */ (function () {
    function CreatCustomerComponent(_services) {
        this._services = _services;
        this.customerAdd = new src_app_common_customer__WEBPACK_IMPORTED_MODULE_1__["Customer"](0, "", "");
    }
    CreatCustomerComponent.prototype.ngOnInit = function () {
    };
    CreatCustomerComponent.prototype.addCustomer = function () {
        this._services.addCustomer(this.customerAdd);
        this.customerAdd.id = 0;
        this.customerAdd.username = "";
        this.customerAdd.userpassword = "";
    };
    CreatCustomerComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-creat-customer',
            template: __webpack_require__(/*! ./creat-customer.component.html */ "./src/app/componennts/creat-customer/creat-customer.component.html"),
            styles: [__webpack_require__(/*! ./creat-customer.component.css */ "./src/app/componennts/creat-customer/creat-customer.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], CreatCustomerComponent);
    return CreatCustomerComponent;
}());



/***/ }),

/***/ "./src/app/componennts/create-company/create-company.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/componennts/create-company/create-company.component.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/create-company/create-company.component.html":
/*!**************************************************************************!*\
  !*** ./src/app/componennts/create-company/create-company.component.html ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n\n\n    <h2 style=\"font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif\"> NEW COMPANY:</h2>\n\n    <div style=\"width: 250px;\">\n <label for=\"inputEmail4\">&nbsp;&nbsp;NAME : &nbsp;</label> <input type=\"text\"  placeholder=\"insert name\" class=\"form-control\" name=\"nametxt\" [(ngModel)]=\"companyAdd.name\"><br>\n <label for=\"inputEmail4\">&nbsp;&nbsp;PASSWORD : &nbsp;</label> <input type=\"password\"  placeholder=\"insert password\"   class=\"form-control\" name=\"passwordtxt\" [(ngModel)]=\"companyAdd.password\"><br>\n <label for=\"inputEmail4\">&nbsp;&nbsp;EMAIL : &nbsp;</label> <input type=\"text\"  placeholder=\"insert email\"   class=\"form-control\" name=\"emailtxt\" [(ngModel)]=\"companyAdd.email\"><br>\n\n<button (click)=\"addCompany()\">CREATE COMPANY</button>\n<br>\n\n\n\n"

/***/ }),

/***/ "./src/app/componennts/create-company/create-company.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/componennts/create-company/create-company.component.ts ***!
  \************************************************************************/
/*! exports provided: CreateCompanyComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateCompanyComponent", function() { return CreateCompanyComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_common_company__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/common/company */ "./src/app/common/company.ts");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CreateCompanyComponent = /** @class */ (function () {
    function CreateCompanyComponent(_services) {
        this._services = _services;
        this.companyAdd = new src_app_common_company__WEBPACK_IMPORTED_MODULE_1__["Company"](0, "", "", "");
    }
    CreateCompanyComponent.prototype.ngOnInit = function () {
    };
    CreateCompanyComponent.prototype.addCompany = function () {
        this._services.addCompany(this.companyAdd);
        this.companyAdd.jsonid = 0;
        this.companyAdd.jsonname = "";
        this.companyAdd.jsonpassword = "";
        this.companyAdd.jsonemail = "";
    };
    CreateCompanyComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-create-company',
            template: __webpack_require__(/*! ./create-company.component.html */ "./src/app/componennts/create-company/create-company.component.html"),
            styles: [__webpack_require__(/*! ./create-company.component.css */ "./src/app/componennts/create-company/create-company.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], CreateCompanyComponent);
    return CreateCompanyComponent;
}());



/***/ }),

/***/ "./src/app/componennts/get-all-companies/get-all-companies.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/componennts/get-all-companies/get-all-companies.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/get-all-companies/get-all-companies.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/componennts/get-all-companies/get-all-companies.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<hr>\n<table style=\"margin-left: 10px\" class=\"table table-striped table-bordered\">\n  <tr>\n    <th>\n      ID\n    </th>\n    <th>\n        NAME\n    </th>\n    <th>\n          PASSWORD\n    </th>          \n    <th>\n      EMAIL\n    </th>\n    <th>\n      <button (click)=\"deleteCompany(i)\">X</button>\n    </th>\n  </tr>\n  \n  <tr *ngFor=\"let comp of companies; let i = index\">\n    <td>{{comp.id}}</td>\n    <td>{{comp.name}}</td>\n    <td>{{comp.password}}</td>\n    <td>{{comp.email}}</td>\n    <td><button (click)=\"deleteCompany(i)\">X</button></td>\n  </tr>\n</table>\n<br>\n<br>\n"

/***/ }),

/***/ "./src/app/componennts/get-all-companies/get-all-companies.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/componennts/get-all-companies/get-all-companies.component.ts ***!
  \******************************************************************************/
/*! exports provided: GetAllCompaniesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GetAllCompaniesComponent", function() { return GetAllCompaniesComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_common_company__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/common/company */ "./src/app/common/company.ts");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GetAllCompaniesComponent = /** @class */ (function () {
    function GetAllCompaniesComponent(_services) {
        var _this = this;
        this._services = _services;
        this.companyAdd = new src_app_common_company__WEBPACK_IMPORTED_MODULE_1__["Company"](0, "", "", "");
        this._services.getAllCompenies().subscribe(function (resp) {
            _this.companies = resp.json();
        });
    }
    GetAllCompaniesComponent.prototype.ngOnInit = function () {
    };
    GetAllCompaniesComponent.prototype.deleteCompany = function (i) {
        var _this = this;
        var company = this.companies[i];
        this._services.deleteCompany(company).subscribe(function (resp) {
            _this.companies.splice(i, 1);
        });
    };
    GetAllCompaniesComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-get-all-companies',
            template: __webpack_require__(/*! ./get-all-companies.component.html */ "./src/app/componennts/get-all-companies/get-all-companies.component.html"),
            styles: [__webpack_require__(/*! ./get-all-companies.component.css */ "./src/app/componennts/get-all-companies/get-all-companies.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], GetAllCompaniesComponent);
    return GetAllCompaniesComponent;
}());



/***/ }),

/***/ "./src/app/componennts/get-all-customers/get-all-customers.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/componennts/get-all-customers/get-all-customers.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/get-all-customers/get-all-customers.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/componennts/get-all-customers/get-all-customers.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<hr>\n<table style=\"margin-left: 10px\" class=\"table table-striped table-bordered\">\n  <tr>\n    <th>\n      ID\n    </th>\n    <th>\n        NAME\n    </th>\n    <th>\n          PASSWORD\n    </th>          \n   \n    <th>\n      <button (click)=\"deleteCustomer(i)\">X</button>\n    </th>\n  </tr>\n  \n  <tr *ngFor=\"let cust of customers; let i = index\">\n    <td>{{cust.id}}</td>\n    <td>{{cust.name}}</td>\n    <td>{{cust.password}}</td>\n  \n    <td><button (click)=\"deleteCustomer(i)\">X</button></td>\n  </tr>\n</table>\n<br>\n<br>\n"

/***/ }),

/***/ "./src/app/componennts/get-all-customers/get-all-customers.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/componennts/get-all-customers/get-all-customers.component.ts ***!
  \******************************************************************************/
/*! exports provided: GetAllCustomersComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GetAllCustomersComponent", function() { return GetAllCustomersComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_common_customer__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! src/app/common/customer */ "./src/app/common/customer.ts");
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GetAllCustomersComponent = /** @class */ (function () {
    function GetAllCustomersComponent(_services) {
        var _this = this;
        this._services = _services;
        this.customerAdd = new src_app_common_customer__WEBPACK_IMPORTED_MODULE_1__["Customer"](0, "", "");
        this._services.getAllCustomers().subscribe(function (resp) {
            _this.customers = resp.json();
        });
    }
    GetAllCustomersComponent.prototype.ngOnInit = function () {
    };
    GetAllCustomersComponent.prototype.deleteCustomer = function (i) {
        var _this = this;
        var customer = this.customers[i];
        this._services.deleteCustomer(customer).subscribe(function (resp) {
            _this.customers.splice(i, 1);
        });
    };
    GetAllCustomersComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-get-all-customers',
            template: __webpack_require__(/*! ./get-all-customers.component.html */ "./src/app/componennts/get-all-customers/get-all-customers.component.html"),
            styles: [__webpack_require__(/*! ./get-all-customers.component.css */ "./src/app/componennts/get-all-customers/get-all-customers.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], GetAllCustomersComponent);
    return GetAllCustomersComponent;
}());



/***/ }),

/***/ "./src/app/componennts/get-company/get-company.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/componennts/get-company/get-company.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/get-company/get-company.component.html":
/*!********************************************************************!*\
  !*** ./src/app/componennts/get-company/get-company.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<h2 style=\"font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif\"> GET COMPANY</h2>\n<div style=\"width: 200px;\">\n<label for=\"inputEmail4\">&nbsp;&nbsp;ID:  &nbsp;</label> \n<input type=\"number\" class=\"form-control\" placeholder=\"insert company id\" name=\"compId\" [(ngModel)]=\"theId\">&nbsp;\n<br>&nbsp;&nbsp;<button (click)=\"getCompany()\">GET COMPANY</button>\n</div>\n<hr>\n<table style=\"margin-left: 10px\" class=\"table table-striped table-bordered\"*ngIf=\"companyAdd\">\n  <tr><th>\n      ID\n    </th>\n    <th>\n        NAME\n    </th>\n    <th>\n          PASSWORD\n    </th>          \n    <th>\n      EMAIL\n    </th>\n    <tr >\n      <td>{{companyAdd.id}}</td>\n      <td>{{companyAdd.name}}</td>\n      <td>{{companyAdd.password}}</td>\n      <td>{{companyAdd.email}}</td>\n    </tr>    \n  </table>\n\n  <h2 style=\"font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif\"> UPDATE COMPANY</h2>\n  <label for=\"inputEmail4\">&nbsp;&nbsp;UPDATE PASSWORD: &nbsp;</label> \n  <div style=\"width: 200px;\">\n  &nbsp;  <input type=\"text\" class=\"form-control\" placeholder=\"insert password\" name=\"updatePass\" [(ngModel)]=\"updatedPassword\"><br>\n  &nbsp;&nbsp;<button (click)=\"changePassword()\" >CHANGE PASSWORD</button>\n  <br><br>\n  <label for=\"inputEmail4\">&nbsp;&nbsp;UPDATE EMAIL:  &nbsp;</label> \n  &nbsp; <input type=\"text\" name=\"updateemail\" class=\"form-control\" placeholder=\"insert new email\" [(ngModel)]=\"updatedemail\"><br>\n  &nbsp;&nbsp; <button (click)=\"changeEmail()\" >CHANGE EMAIL</button>\n</div>"

/***/ }),

/***/ "./src/app/componennts/get-company/get-company.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/componennts/get-company/get-company.component.ts ***!
  \******************************************************************/
/*! exports provided: GetCompanyComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GetCompanyComponent", function() { return GetCompanyComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GetCompanyComponent = /** @class */ (function () {
    function GetCompanyComponent(_services) {
        this._services = _services;
    }
    GetCompanyComponent.prototype.ngOnInit = function () {
    };
    GetCompanyComponent.prototype.getCompany = function () {
        var _this = this;
        this._services.getCompany(this.theId).subscribe(function (resp) {
            _this.companyAdd = resp.json();
        }, function (error) {
            var err = error._body;
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'error',
                text: err,
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        });
    };
    GetCompanyComponent.prototype.changePassword = function () {
        this.companyAdd.password = this.updatedPassword;
        this._services.changePassword(this.companyAdd);
    };
    GetCompanyComponent.prototype.changeEmail = function () {
        this.companyAdd.email = this.updatedemail;
        this._services.changeEmail(this.companyAdd);
    };
    GetCompanyComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-get-company',
            template: __webpack_require__(/*! ./get-company.component.html */ "./src/app/componennts/get-company/get-company.component.html"),
            styles: [__webpack_require__(/*! ./get-company.component.css */ "./src/app/componennts/get-company/get-company.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], GetCompanyComponent);
    return GetCompanyComponent;
}());



/***/ }),

/***/ "./src/app/componennts/get-customer/get-customer.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/componennts/get-customer/get-customer.component.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/componennts/get-customer/get-customer.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/componennts/get-customer/get-customer.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n<h2 style=\"font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif\"> GET CUSTOMER</h2>\n\n<div style=\"width: 300px\">\n<label for=\"inputEmail4\">&nbsp;&nbsp;ID:  &nbsp;</label> \n<input type=\"number\"  class=\"form-control\"  name=\"id\" placeholder=\"insert customer id\" [(ngModel)]=\"theId\"><br>\n&nbsp;&nbsp;<button (click)=\"getCustomer()\">GET CUSTOMER</button>\n</div>\n\n\n\n<hr>\n<table style=\"margin-left: 10px\" class=\"table table-striped table-bordered\" *ngIf=\"customerAdd\">\n  \n  <tr>\n    <th>\n      ID\n    </th>\n    <th>\n        NAME\n    </th>\n    <th>\n          PASSWORD\n    </th>     \n     <tr >\n      <td>{{customerAdd.id}}</td>\n      <td>{{customerAdd.name}}</td>\n      <td>{{customerAdd.password}}</td>\n    \n      \n    </tr>    \n  </table>\n <br>  <label for=\"inputEmail4\">&nbsp;&nbsp;UPDATE PASSWORD: &nbsp;</label> \n    <input type=\"text\"  style=\"width: 300px\" class=\"form-control\"  name=\"updatePass\" [(ngModel)]=\"updatedPassword\"placeholder=\"insert new password\">&nbsp;\n  <br>&nbsp; <button (click)=\"changePassword()\" >CHANGE PASSWORD</button>\n \n  "

/***/ }),

/***/ "./src/app/componennts/get-customer/get-customer.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/componennts/get-customer/get-customer.component.ts ***!
  \********************************************************************/
/*! exports provided: GetCustomerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GetCustomerComponent", function() { return GetCustomerComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _services_app_services_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./../../../services/app-services.service */ "./src/services/app-services.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GetCustomerComponent = /** @class */ (function () {
    function GetCustomerComponent(_services) {
        this._services = _services;
    }
    GetCustomerComponent.prototype.ngOnInit = function () {
    };
    GetCustomerComponent.prototype.getCustomer = function () {
        var _this = this;
        this._services.getCustomer(this.theId).subscribe(function (resp) {
            _this.customerAdd = resp.json();
        }, function (error) {
            var err = error._body;
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'error',
                text: err,
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        });
    };
    GetCustomerComponent.prototype.changePassword = function () {
        this.customerAdd.password = this.updatedPassword;
        this._services.changeCustomerPassword(this.customerAdd);
    };
    GetCustomerComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-get-customer',
            template: __webpack_require__(/*! ./get-customer.component.html */ "./src/app/componennts/get-customer/get-customer.component.html"),
            styles: [__webpack_require__(/*! ./get-customer.component.css */ "./src/app/componennts/get-customer/get-customer.component.css")]
        }),
        __metadata("design:paramtypes", [_services_app_services_service__WEBPACK_IMPORTED_MODULE_2__["AppServicesService"]])
    ], GetCustomerComponent);
    return GetCustomerComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ "./src/services/app-services.service.ts":
/*!**********************************************!*\
  !*** ./src/services/app-services.service.ts ***!
  \**********************************************/
/*! exports provided: AppServicesService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppServicesService", function() { return AppServicesService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppServicesService = /** @class */ (function () {
    function AppServicesService(_http) {
        this._http = _http;
    }
    AppServicesService.prototype.addCustomer = function (customer) {
        this._http.post("http://localhost:8080/coupon/createCustomer", customer).subscribe(function (resp) {
            console.log(resp);
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'Sweet!',
                text: 'a new customer !',
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        }, function (error) {
            var txt = error._body;
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'error',
                text: txt,
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        });
    };
    AppServicesService.prototype.addCompany = function (company) {
        this._http.post("http://localhost:8080/coupon/CreateCompany", company).subscribe(function (resp) {
            console.log(resp);
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'Sweet!',
                text: 'a new company !',
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        }, function (error) {
            var err = error._body;
            sweetalert2__WEBPACK_IMPORTED_MODULE_1___default()({
                title: 'error!',
                text: err,
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                imageAlt: 'Custom image',
                animation: false
            });
        });
    };
    AppServicesService.prototype.getAllCompenies = function () {
        return this._http.get("http://localhost:8080/coupon/getAllCompanies");
    };
    AppServicesService.prototype.deleteCompany = function (company) {
        return this._http.delete("http://localhost:8080/coupon/removeCompany", new _angular_http__WEBPACK_IMPORTED_MODULE_2__["RequestOptions"]({
            body: company
        }));
    };
    AppServicesService.prototype.getAllCustomers = function () {
        return this._http.get("http://localhost:8080/coupon/getAllCustomers");
    };
    AppServicesService.prototype.deleteCustomer = function (customer) {
        return this._http.delete("http://localhost:8080/coupon/removeCustomer", new _angular_http__WEBPACK_IMPORTED_MODULE_2__["RequestOptions"]({
            body: customer
        }));
    };
    AppServicesService.prototype.getCompany = function (companyId) {
        return this._http.get("http://localhost:8080/coupon/getCompany/" + companyId);
    };
    AppServicesService.prototype.changePassword = function (company) {
        this._http.put("http://localhost:8080/coupon/updateCompany", company).subscribe(function (resp) {
        });
    };
    AppServicesService.prototype.changeEmail = function (company) {
        this._http.put("http://localhost:8080/coupon/updateCompany", company).subscribe(function (resp) {
        });
    };
    AppServicesService.prototype.getCustomer = function (theId) {
        return this._http.get("http://localhost:8080/coupon/getCustomer/" + theId);
    };
    AppServicesService.prototype.changeCustomerPassword = function (customer) {
        this._http.put("http://localhost:8080/coupon/updateCustomer", customer).subscribe(function (resp) {
        });
    };
    AppServicesService.prototype.logOut = function () {
        return this._http.delete("http://localhost:8080/coupon/logOut");
    };
    AppServicesService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_http__WEBPACK_IMPORTED_MODULE_2__["Http"]])
    ], AppServicesService);
    return AppServicesService;
}());



/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\User\Desktop\ng-builded\admin-web-api\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map