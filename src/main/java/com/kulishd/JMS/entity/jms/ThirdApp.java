package com.kulishd.JMS.entity.jms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.kulishd.JMS.entity.SummaryInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ThirdApp {

    private static final String FILE_NAME = "logs.txt";

    @JmsListener(destination = "summary-queue", containerFactory = "myFactory")
    public void receiveMessage(SummaryInfo summaryInfo) throws IOException {
        log.info("Message received " + summaryInfo);
        writeLogsToFile(summaryInfo);
    }

    private void writeLogsToFile(SummaryInfo str) throws IOException {
        var writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(String.valueOf(str));
        writer.close();
    }
}
