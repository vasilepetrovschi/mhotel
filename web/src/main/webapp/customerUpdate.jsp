<%@page import="java.util.ArrayList"%>
<%@page import="mhotel.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="mhotel.model.CustomerRecord"%>
<%@page import="mhotel.model.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update customer</title>
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
    position: relative;
    left: 150px;
}
.registerbtn:hover {
    opacity: 5;
}

.autocomplete {
  /*the container must be positioned relative:*/
  position: relative;
  display: inline-block;
  
}

.autocomplete-items {
  position: absolute;
  border: 1px solid #d4d4d4;
  border-bottom: none;
  border-top: none;
  z-index: 99;
  /*position the autocomplete items to be the same width as the container:*/
  top: 100%;
  left: 105px;
  right: 0px;
}
.autocomplete-items div {
  padding: 10px;
  cursor: pointer;
  background-color: #E0F8F7; 
  border-bottom: 1px solid #d4d4d4; 
}
.autocomplete-items div:hover {
  /*when hovering an item:*/
  background-color: #F5A9A9; 
}
.autocomplete-active {
  /*when navigating through the items using the arrow keys:*/
  background-color: DodgerBlue !important; 
  color: #ffffff; 
}
</style>

</head>
<body>
	<div>
		<a href='<%=request.getContextPath() + "/"%>'>HOME</a>
	</div>
	<div>
		<%
			Customer customerDetails = (Customer) request.getAttribute("customer");
		%>
	</div>
	
	<div >
  	  <% ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors"); %>
  	 
  			<%
				for (String error : errors) {
			%>
			<%=error %><br>
  <% } %>

    <form autocomplete="off" action="<%=request.getContextPath() %>/customer/update" method="post">
    
    	<input type="hidden" name="cust_id" value="<%=customerDetails.getId()%>">
      <b>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the name"
      			placeholder = "EX: Jhon" onfocusout="this.placeholder='EX: Jhon'"
  	  			onfocus="this.placeholder=''" type="text" name="nume" value="<%=customerDetails.getName()%>" required="required"
 				oninvalid="this.setCustomValidity('Please enter valid name')"
 				oninput="setCustomValidity('')" ></input><br>
      <b>Sex:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
      
      <%
			if (customerDetails.getSex().equalsIgnoreCase("M")) {
		%>
		<input type="radio" name="sex" value="M" checked="checked"> Male 
		<input type="radio" name="sex" value="F"> Female<br>
		<%
			} else {
		%>
		<input type="radio" name="sex" value="M"> Male
		<input type="radio" name="sex" value="F" checked="checked"> Female<br>
				<%
			}
		%>
  	  <b>Identity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the identity" 
  	  			placeholder = "EX: IF 456123" onfocusout="this.placeholder='EX: IF 456123'"
  	  			onfocus="this.placeholder=''" type="text" name="id" value="<%=customerDetails.getLegalId()%>"><br>
  	  <b>Identity Type: </b><input title= "Insert the identity type" placeholder="EX: CI" onfocusout="this.placeholder='EX: CI'"
  	 			onfocus="this.placeholder=''" type="text" name="idType" value="<%=customerDetails.getLegalIdType()%>"><br>
  	  <b>Birthday:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the birthday" type="date" name="bday"
  	  			value="<%=customerDetails.getBirthday()%>"><br>
  	  <b>Address</b><br>
  	  <div class="autocomplete" >
  	  <input type="hidden" name="addr_id" value="<%=customerDetails.getAddress().getId()%>">
  	  <b>Country:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input style="width:200px;" id="countriesList" 
  	  			title= "Insert the country" placeholder = "EX: Romania" onfocusout="this.placeholder='EX: Romania'"
  	  			onfocus="this.placeholder=''" type="text" name="addr_country" value="<%=customerDetails.getAddress().getCountry()%>" 
  	  			required="required" oninvalid="this.setCustomValidity('Please enter valid country')"
 				oninput="setCustomValidity('')"></input><br>
 		</div><br>
  	  <b>City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the city" placeholder = "EX: Bucharest" onfocusout="this.placeholder='EX: Bucharest'"
  	 			onfocus="this.placeholder=''" type="text" name="addr_city" value="<%=customerDetails.getAddress().getCity()%>"><br>
  	  <b>Street: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the street" 
  	  			placeholder = "EX: Nicolae Balcescu" onfocusout="this.placeholder='EX: Nicolae Balcescu'"
  	  			onfocus="this.placeholder=''" type="text" name="addr_street" value="<%=customerDetails.getAddress().getStreet()%>"><br>
  	  <b>Number:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the number" placeholder = "EX: 33bis"
  	  			onfocusout="this.placeholder='EX: 33bis'" onfocus="this.placeholder=''" type="text" name="addr_nbr"
  	  			value="<%=customerDetails.getAddress().getNumber()%>"><br>
  	  <b>Zip code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input title= "Insert the zip code" placeholder = "EX: 123456"
  	  			onfocusout="this.placeholder='EX: 123456'" onfocus="this.placeholder=''" type="text" name="addr_cp"
  	  			value="<%=customerDetails.getAddress().getPostalCode()%>"><br>
  	  <button type="submit" class="registerbtn">  <b>Salveaza</b></button>
    </form>
    
    <script>
function autocomplete(inp, arr) {
  /*the autocomplete function takes two arguments,
  the text field element and an array of possible autocompleted values:*/
  var currentFocus;
  /*execute a function when someone writes in the text field:*/
  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
      /*close any already open lists of autocompleted values*/
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      /*create a DIV element that will contain the items (values):*/
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
      /*append the DIV element as a child of the autocomplete container:*/
      this.parentNode.appendChild(a);
      /*for each item in the array...*/
      for (i = 0; i < arr.length; i++) {
        /*check if the item starts with the same letters as the text field value:*/
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
          /*create a DIV element for each matching element:*/
          b = document.createElement("DIV");
          /*make the matching letters bold:*/
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
          /*insert a input field that will hold the current array item's value:*/
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
          /*execute a function when someone clicks on the item value (DIV element):*/
          b.addEventListener("click", function(e) {
              /*insert the value for the autocomplete text field:*/
              inp.value = this.getElementsByTagName("input")[0].value;
              /*close the list of autocompleted values,
              (or any other open lists of autocompleted values:*/
              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
  /*execute a function presses a key on the keyboard:*/
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        currentFocus++;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 38) { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        currentFocus--;
        /*and and make the current item more visible:*/
        addActive(x);
      } else if (e.keyCode == 13) {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
          /*and simulate a click on the "active" item:*/
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    /*add class "autocomplete-active":*/
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    /*a function to remove the "active" class from all autocomplete items:*/
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  /*execute a function when someone clicks in the document:*/
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
      });
}

/*An array containing all the country names in the world:*/
var countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua & Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central Arfrican Republic","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauro","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre & Miquelon","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","St Kitts & Nevis","St Lucia","St Vincent","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Turks & Caicos","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];

/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("countriesList"), countries);
</script>
  </div>
</body>
</html>