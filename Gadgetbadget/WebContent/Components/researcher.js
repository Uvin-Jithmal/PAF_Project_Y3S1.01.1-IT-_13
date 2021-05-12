$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#formResearcher").submit();
});
// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidResearcherIDSave").val(
					$(this).closest("tr").find('#hidResearcherIDUpdate').val());
			$("#txtRName").val($(this).closest("tr").find('td:eq(0)').text());
			$("#txtEmail").val($(this).closest("tr").find('td:eq(1)').text());
			$("#txtAbout").val($(this).closest("tr").find('td:eq(2)').text());
			$("#txtPName").val($(this).closest("tr").find('td:eq(3)').text());
			$("#txtPDescription").val($(this).closest("tr").find('td:eq(4)').text());
			$("#txtPPrice").val($(this).closest("tr").find('td:eq(5)').text());
		});
// CLIENT-MODEL================================================================
function validateItemForm() {
	// Researcher Name
	if ($("#txtRName").val().trim() == "") {
		return "Insert Researcher Name.";
	}
	// Researcher Email
	if ($("#txtEmail").val().trim() == "") {
		return "Insert Researcher Email.";
	}
	// About Researcher 
	if ($("#txtAbout").val().trim() == "") {
		return "Insert a short description About Researcher.";
	}
	// Project Name 
	if ($("#txtPName").val().trim() == "") {
		return "Insert Project Name.";
	}
	// Project description
	if ($("#txtPDescription").val().trim() == "") {
		return "Insert a short description About Project.";
	}
	
	// Project PRICE-------------------------------
	if ($("#txtPPrice").val().trim() == "") {
		return "Insert Project Price.";
	}
	// is numerical value
	var tmpPrice = $("#txtPPrice").val().trim();
	if (!$.isNumeric(tmpPrice)) {
		return "Insert a numerical value for Item Price.";
	}
	
	return true;
}