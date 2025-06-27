package com.baishang.mcpserveroracle;

import com.baishang.mcpserveroracle.business.service.DatabaseMetadataService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@MapperScan("com.baishang.mcpserveroracle.business.mapper")
@EnableScheduling
public class McpServerOracleApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerOracleApplication.class, args);
    }

    @Bean
    public List<ToolCallback> oracleDataBaseTools(DatabaseMetadataService databaseMetadataService) {
        return List.of(ToolCallbacks.from(databaseMetadataService));
    }
}
