/*global require, module*/
const ApiBuilder = require('claudia-api-builder'),
	https = require('https'),
	api = new ApiBuilder(),
	fs = require('fs'),
	util = require('util');

module.exports = api;

const TOMTOM_HOST = 'https://api.tomtom.com';
const TOMTOM_KEY = 'NcxRyApajRzivcKOxPHN3d130zYT2BO7';

const getURL = (endpoint, locations, params) => {
	return `${TOMTOM_HOST}/${endpoint}/${locations}/${params}`;
}

let MOCK_DATA = {
	"summary": {
		"lengthInMeters": 1112,
		"travelTimeInSeconds": 801,
		"trafficDelayInSeconds": 0,
		"departureTime": "2019-12-11T14:40:19+01:00",
		"arrivalTime": "2019-12-11T14:53:39+01:00"
	},
	"legs": [{
		"summary": {
			"lengthInMeters": 1112,
			"travelTimeInSeconds": 801,
			"trafficDelayInSeconds": 0,
			"departureTime": "2019-12-11T14:40:19+01:00",
			"arrivalTime": "2019-12-11T14:53:39+01:00"
		},
		"points": [{
				"latitude": 52.5093,
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
				"longitude": 13.4288
			},
			{
				"latitude": 52.5084,
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
				"latitude": 52.5073,
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
				"latitude": 52.5033,
				"longitude": 13.43767
			},
			{
				"latitude": 52.50275,
				"longitude": 13.43873
			}
		]
	}],
	"sections": [{
		"startPointIndex": 0,
		"endPointIndex": 21,
		"sectionType": "TRAVEL_MODE",
		"travelMode": "pedestrian"
	}]
};

api.post('/trips', function (newparams) {
	const endpoint = 'routing/1/calculateRoute';
	const params = `json?computeBestOrder=true&sectionType=travelMode&report=effectiveSettings&routeType=fastest&traffic=true&avoid=unpavedRoads&travelMode=pedestrian&key=${TOMTOM_KEY}`;
	const locations = '52.50931,13.42936:52.50274,13.43872';
	const URL = getURL(endpoint, locations, params);


	return {summary: {...newparams, ...MOCK_DATA.summary}, ...MOCK_DATA};
})