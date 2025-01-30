package com.examples.junit.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailServiceTests {

    @Mock
    DeliveryPlatform platform;

    @InjectMocks
    EmailService emailService;

    @Captor
    ArgumentCaptor<Email> emailCaptor;

    @Test
    void whenDoesSupportHtml_expectHTMLEmailFormat() {
        String to = "info@abc.com";
        String subject = "Testing ArgumentCaptor";
        String body = "Hello, Welcome!!!";

        emailService.send(to, subject, body, true);

        verify(platform).deliver(emailCaptor.capture());

        Email value = emailCaptor.getValue();
        assertEquals(Format.HTML, value.getFormat());
    }
}
