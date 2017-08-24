package com.alacriti.empleavetool.constants;

import com.alacriti.empleavetool.vo.Error;;

public class ErrorConstants {

	public static final Error NO_RECORD_FOUND_WITH_GIVEN_REQUEST_PARAMETERS = new Error("error_req_param",
			"No record found with given request parameters", "");

	public static final Error PROCESS_ERROR = new Error("error_process", "Could not process the request", "");

	public static final Error CLIENT_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "client_id");

	public static final Error CONFIRM_CHARGE_REQUEST_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "confirm_charge_request");

	public static final Error ACCOUNT_NUMBER_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "account_number");

	public static final Error EXPIRY_DATE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "expiry_date");

	public static final Error CARD_CVV_NUMBER_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "card_cvv_number");

	public static final Error EMAIL_ERROR = new Error("error_field", "The request contains a field with invalid value.",
			"email");

	public static final Error CHARGE_AMOUNT_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "charge_amount");

	public static final Error ABA_ROUTING_NUMBER_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "aba_routing_number");

	public static final Error ACCOUNT_ISSUING_INSTITUTION_NAME_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "account_issuing_institution_name");

	public static final Error CURRENCY_CODE3D_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "currency_code3d");

	public static final Error ACCOUNT_TYPE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "account_type");

	public static final Error ACCOUNT_SUBTYPE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "account_subtype");

	public static final Error ACCOUNT_HOLDER_NAME_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "account_holder_name");

	public static final Error PHONE_NUMBER_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "phone_number");

	public static final Error VALIDATE_CHARGE_REQUEST_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "validate_charge_request");

	public static final Error CUSTOMER_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "customer");

	public static final Error FUNDING_ACCOUNT_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "funding_account");

	public static final Error SAVE_FOR_FUTURE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "save_for_future");

	public static final Error CHARGE_AMOUNT_CURRENCY_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "charge_amount_currency");

	public static final Error ADDRESS_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address");

	public static final Error ADDRESS_LINE1_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_line1");

	public static final Error ADDRESS_LINE2_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_line2");

	public static final Error ADDRESS_CITY_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_city");

	public static final Error ADDRESS_STATE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_state");

	public static final Error ADDRESS_COUNTRY_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_country");

	public static final Error ADDRESS_ZIP1_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_zip1");

	public static final Error ADDRESS_ZIP2_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "address_zip2");

	public static final Error ORDER_REF_NO_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "order_ref_no");

	public static final Error CUSTOMER_EXT_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "customer_ext_id");

	public static final Error CUSTOMER_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "customer_id");
	public static final Error FIRST_NAME_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "first_name");

	public static final Error LAST_NAME_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "last_name");

	public static final Error TOKEN_ERROR = new Error("error_field", "The request contains a field with invalid value.",
			"token_id");

	public static final Error SOURCE_TYPE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "source_type");

	public static final Error INITIAL_RECORDS_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "initialRecords");

	public static final Error PAYMENT_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "ID_PAYMENT");

	public static final Error EDIT_PAYMENT_REQUEST_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "edit_payment_request");

	public static final Error FUNDING_ACCOUNT_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "funding_account.id");
	public static final Error EDIT_FUNDING_ACCOUNT_REQUEST_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "edit_funding_account_request");
	public static final Error QUERY_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "query_id");
	public static final Error FROM_TO_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "");

	public static final Error CONFIRMATION_ID_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "confirmation_id");
	public static final Error FROM_DATE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "from_date");
	public static final Error TO_DATE_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "to_date");
	public static final Error PAYMENT_STATUS_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "payment_status");

	public static final Error USER_AGENT_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "user_agent");
	public static final Error IP_ADDRESS_ERROR = new Error("error_field",
			"The request contains a field with invalid value.", "ip_address");

	public static final String ERR_GENERIC_DAO = "11005";
	public static final String ERR_GENERIC = "11020";
}
