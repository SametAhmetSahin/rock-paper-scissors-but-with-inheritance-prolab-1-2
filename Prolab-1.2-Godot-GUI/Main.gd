extends Node2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
var request

func get_request(url, parameters=""):
	var error = request.request(url + str(parameters))
	if error != OK:
		push_error("An error occured")

func dict_to_get_parameters(dict):
	var result = ""
	for key in dict.keys():
		result += key + "=" + str(dict[key])
		if key != dict.keys()[-1]:
			result += "&"
	return result
# Called when the node enters the scene tree for the first time.
func _ready():
	request = HTTPRequest.new()
	add_child(request)
	request.connect("request_completed", self, "_http_request_completed")
	var dict = {"name":"bob", "age":17, "city":"nusretcity"}
	
	get_request("http://localhost:8080/get?", dict_to_get_parameters(dict))

func _http_request_completed(result, response_code, headers, body):
	print(body.get_string_from_utf8())
