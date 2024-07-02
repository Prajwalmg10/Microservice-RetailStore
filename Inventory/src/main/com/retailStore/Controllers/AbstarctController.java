package Inventory.src.main.com.retailStore.Controllers;

import Customer.src.main.com.retailStore.uiResponse.DataException;
import Customer.src.main.com.retailStore.uiResponse.UIResponse;
import Customer.src.main.com.retailStore.uiResponse.UiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstarctController {

    protected ResponseEntity<UIResponse<String>> buildSuccessMessage(final String msg)
    {
        final UIResponse<String> message = new UIResponse<>();
        message.setMessage(msg);
        message.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
        protected <T> ResponseEntity<UIResponse<T>> buildResponse(final T t) {
            final UIResponse<T> uiResponse = new UIResponse<>(t);
            uiResponse.setEntity(t);
            uiResponse.setStatus(HttpStatus.OK.value());
            uiResponse.setMessage("Success");
            return new ResponseEntity<>(uiResponse, HttpStatus.OK);
        }

        public ResponseEntity<UiError<?>> buildError(final DataException e) {
            final UiError<?> message = new UiError<>();
            message.setMessageCode(e.getErrorCode());
            message.setMessage(e.getErrorMessage());
            if (e.getHttpStatus().equals(HttpStatus.BAD_REQUEST)) {
                message.setStatus(HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
            if (e.getHttpStatus().equals(HttpStatus.FORBIDDEN)) {
                message.setStatus(HttpStatus.FORBIDDEN.value());
                return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
            }
            if (e.getHttpStatus().equals(HttpStatus.NOT_FOUND)) {
                message.setStatus(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
            if (e.getHttpStatus().equals(HttpStatus.CONFLICT)) {
                message.setStatus(HttpStatus.CONFLICT.value());
                return new ResponseEntity<>(message, HttpStatus.CONFLICT);
            }
            if (e.getHttpStatus().equals(HttpStatus.resolve(419))) {
                message.setStatus(HttpStatus.resolve(419).value());
                return new ResponseEntity<>(message, HttpStatus.resolve(419));
            }
            message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
