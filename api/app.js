/*global require, module*/
var ApiBuilder = require('claudia-api-builder'),
	fetch = require('node-fetch'),
	api = new ApiBuilder(),
	AWS = require('aws-sdk'),
	dynamoDb = new AWS.DynamoDB.DocumentClient(),
	fs = require('fs'),
	util = require('util');

const MOCK_DATA = {
	berlin: {
		"summary": {
			"lengthInMeters": 1112,
			"travelTimeInSeconds": 801,
			"trafficDelayInSeconds": 0,
			"departureTime": "2019-12-12T10:15:52+01:00",
			"arrivalTime": "2019-12-12T10:29:12+01:00"
		},
		"legs": [{
			"summary": {
				"lengthInMeters": 1112,
				"travelTimeInSeconds": 801,
				"trafficDelayInSeconds": 0,
				"departureTime": "2019-12-12T10:15:52+01:00",
				"arrivalTime": "2019-12-12T10:29:12+01:00"
			},
			"points": [{
					"latitude": 52.50930,
					"longitude": 13.42937
				},
				{
					"latitude": 52.50904,
					"longitude": 13.42913
				},
				{
					"latitude": 52.50895,
					"longitude": 13.42904
				},
				{
					"latitude": 52.50868,
					"longitude": 13.42880
				},
				{
					"latitude": 52.50840,
					"longitude": 13.42857
				},
				{
					"latitude": 52.50821,
					"longitude": 13.42843
				},
				{
					"latitude": 52.50791,
					"longitude": 13.42825
				},
				{
					"latitude": 52.50735,
					"longitude": 13.42824
				},
				{
					"latitude": 52.50730,
					"longitude": 13.42837
				},
				{
					"latitude": 52.50673,
					"longitude": 13.42961
				},
				{
					"latitude": 52.50619,
					"longitude": 13.43092
				},
				{
					"latitude": 52.50574,
					"longitude": 13.43195
				},
				{
					"latitude": 52.50528,
					"longitude": 13.43299
				},
				{
					"latitude": 52.50513,
					"longitude": 13.43336
				},
				{
					"latitude": 52.50464,
					"longitude": 13.43451
				},
				{
					"latitude": 52.50451,
					"longitude": 13.43482
				},
				{
					"latitude": 52.50444,
					"longitude": 13.43499
				},
				{
					"latitude": 52.50418,
					"longitude": 13.43564
				},
				{
					"latitude": 52.50372,
					"longitude": 13.43673
				},
				{
					"latitude": 52.50343,
					"longitude": 13.43738
				},
				{
					"latitude": 52.50330,
					"longitude": 13.43767
				},
				{
					"latitude": 52.50275,
					"longitude": 13.43873
				}
			]
		}]
	}
}

module.exports = api;

const TOMTOM_HOST = 'https://api.tomtom.com';
const TOMTOM_KEY = 'NcxRyApajRzivcKOxPHN3d130zYT2BO7';

const getURL = (endpoint, params) => {
	return `${TOMTOM_HOST}/${endpoint}${params}`;
}

api.post('/users', function (request) {
	'use strict';
	var params = {
		TableName: 'user',
		Item: {
			userId: request.body.userId,
			name: request.body.name,
			age: request.body.age
		}
	};
	return dynamoDb.put(params).promise();
}, {
	success: 201
});

api.get('/users/{id}', function (request) {
	'use strict';
	var id, params;
	id = request.pathParams.id;
	params = {
		TableName: 'user',
		Key: {
			userId: id
		}
	};

	return dynamoDb.get(params).promise().then(function (response) {
		return response.Item;
	});
});

api.delete('/users/{id}', function (request) {
	'use strict';
	var id, params;
	id = request.pathParams.id;
	params = {
		TableName: 'user',
		Key: {
			userId: id
		}
	};

	return dynamoDb.delete(params).promise()
		.then(function () {
			return 'Deleted user with id "' + id + '"';
		});
}, {
	success: {
		contentType: 'text/plain'
	}
});

api.get('/categories', async function (req) {
	const endpoint = 'search/2/poiCategories.json';
	const params = `?key=${TOMTOM_KEY}`;
	const url = getURL(endpoint, params);

	const response = await fetch(url);
	const categories = await response.json();

	return categories;

});

api.post('/points', function (req) {
	const data = req.body;
	const {
		city,
		startTime,
		endTime
	} = data;

	return city ? MOCK_DATA[city] : MOCK_DATA['berlin'];
});

api.get('/trips/{city}', function (req) {
	const city = req.pathParams.city;
	const endpoint = 'routing/1/calculateRoute';
	const params = `json?computeBestOrder=true&sectionType=travelMode&report=effectiveSettings&routeType=fastest&traffic=true&avoid=unpavedRoads&travelMode=pedestrian&key=${TOMTOM_KEY}`;

	if (!city) return 'error';

	const url = getURL(endpoint, params);

	const response = await fetch(url);
	const points = await response.json();

	return points ? MOCK_DATA[city] : MOCK_DATA['berlin'];
})

api.addPostDeployConfig('tableName', 'DynamoDB Table Name:', 'configure-db');