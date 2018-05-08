<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer to add</title>
<link href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: #D8D8D8;
}

/* Full-width input fields */
input[type=text], input[type=date] {
    width: 15%;
    padding: 5px;
    margin: 2px 0 5px 0;
    border: inset;
    background: #E0F8F7;
    
}
input[type=text]:focus, input[type=date]:focus {
    background-color: #F5A9A9;
    outline: none;
}
/* Set a style for the submit button */
.registerbtn {
    background-color: #A4A4A4;
    color: black;
    padding: 5px;
    margin: 8px 0;
    border: solid;
    cursor: pointer;
    width: 10%;
    opacity: 0.7;
}
.registerbtn:hover {
    opacity: 5;
}
</style>
</head>

<script>
$(function(){
var countries = ["Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", 
	"Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
	"Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", 
	"British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", 
	"Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands",
	"Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", 
	"Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", 
	"El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", 
	"Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia",
	"Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
	"Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", 
	"India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan",
	"Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", 
	"Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", 
	"Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
	"Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco",
	"Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", 
	"New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", 
	"Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", 
	"Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", 
	"Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", 
	"Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", 
	"South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", 
	"Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", 
	"Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
	"Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", 
	"United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", 
	"Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"];
$("#autocomplete").autocomplete({
source: countries
});
});
</script>

<body>
  <div>
  	  <% ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors"); %>
  	 
  			<%
				for (String error : errors) {
			%>
			<%=error %><br>
  <% } %>

    <form action="<%=request.getContextPath() %>/customer/add" method="post">
    
      <b>Nume:</b><input title= "Insert the name" type="text" name="nume" required="required"
 				oninvalid="this.setCustomValidity('Please enter valid name')"
 				oninput="setCustomValidity('')"></input><br>
      <b>Sex:</b> <input type="radio" name="sex" value="M"> Male
  					<input type="radio" name="sex" value="F"> Female<br>
  	  <b>Identity:</b><input placeholder = "EX: IF 456123" onfocusout="this.placeholder='EX: IF 456123'"
  	  onfocus="this.placeholder=''" type="text" name="id"><br>
  	  <b>Identity Type:</b><input placeholder="EX: CI" onfocusout="this.placeholder='EX: CI'"
  	  onfocus="this.placeholder=''" type="text" name="idType"><br>
  	  <b>Birthday:</b><input type="date" name="bday"><br>
  	  <b>Adresa</b><br>
  	  <b>Tara:</b><input type="text" name="addr_country" required="required"
  	  			oninvalid="this.setCustomValidity('Please enter valid country')"
 				oninput="setCustomValidity('')" id="autocomplete"></input><br>
  	  <b>Oras:</b><input type="text" name="addr_city"><br>
  	  <b>Strada:</b><input title= "Insert the street" type="text" name="addr_street"><br>
  	  <b>Numar:</b><input title= "Insert the number" type="text" name="addr_nbr"><br>
  	  <b>Cod postal:</b><input type="text" name="addr_cp"><br>
  	  <button type="submit" class="registerbtn">  <b>Salveaza </b></button>
    </form>
  </div>
</body>
</html>