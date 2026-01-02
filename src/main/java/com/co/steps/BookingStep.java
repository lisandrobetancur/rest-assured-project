package com.co.steps;

import static com.co.utils.AssertUtils.assertStatusCode;
import static com.co.utils.Path.AUTH_PATH;
import static com.co.utils.Path.BOOKING_PATH_ID;
import static com.co.utils.VarSession.USER_TOKEN;

import com.co.api.BaseApi;
import com.co.model.AuthRequest;
import com.co.model.Booking;
import com.co.model.BookingDates;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.SoftAssertions;

public class BookingStep extends BaseApi {

    private int bookingId;

    @Step("Login with username {0} and password {1}")
    public void login(String username, String password) {
        AuthRequest payload = AuthRequest.builder().username(username).password(password).build();

        Response response = new BookingStep().postWithOutAuth(AUTH_PATH.getValue(), payload);

        assertStatusCode(response.getStatusCode(), 200);

        String token = response.jsonPath().getString("token");
        Serenity.setSessionVariable(USER_TOKEN.getValue()).to(token);
    }

    @Step("Search for booking with ID {0}")
    public void searchBooking(int bookingId) {
        this.bookingId = bookingId;
        int statusCode =
                new BookingStep()
                        .getWithOutAuthAndPathParam(BOOKING_PATH_ID.getValue(), bookingId)
                        .getStatusCode();

        assertStatusCode(statusCode, 200);
    }

    @Step("new firstname {0} and lastname {1}")
    public void updateFirstnameAndLastName(String firstname, String lastname) {
        Booking payload1 =
                Booking.builder()
                        .firstName(firstname)
                        .lastName(lastname)
                        .totalPrice(111)
                        .depositPaid(false)
                        .bookingDates(
                                BookingDates.builder()
                                        .checkin("2020-01-01")
                                        .checkout("2022-01-01")
                                        .build())
                        .additionalNeeds("Breakfast")
                        .build();

        String payload =
                "{\n"
                        + "    \"firstname\" : \"Juanito\",\n"
                        + "    \"lastname\" : \"Perez\",\n"
                        + "    \"totalprice\" : 111,\n"
                        + "    \"depositpaid\" : true,\n"
                        + "    \"bookingdates\" : {\n"
                        + "        \"checkin\" : \"2018-01-01\",\n"
                        + "        \"checkout\" : \"2019-01-01\"\n"
                        + "    },\n"
                        + "    \"additionalneeds\" : \"Breakfast\"\n"
                        + "}";
        Response response =
                new BookingStep()
                        .putWithAuthAndPathParam(
                                BOOKING_PATH_ID.getValue(), payload, this.bookingId);

        assertStatusCode(response.getStatusCode(), 200);

        Booking booking = response.as(Booking.class);

        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(booking.getFirstName()).isEqualTo("Juanito");
                    softly.assertThat(booking.getLastName()).isEqualTo("Perez");
                });
    }
}
