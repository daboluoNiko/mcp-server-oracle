# MCP Server for Oracle Database

## Overview

`mcp-server-oracle` is a Java-based server application designed to connect to Oracle 11g databases. Built with Java 17+ features, it provides a reliable interface for database operations.

## Features

- Oracle 11g database connectivity
- Java 17+ compatibility
- Lightweight and efficient architecture
- Simple configuration
- JDBC connection pooling

## Prerequisites

- **Java 17** or higher (recommended: Amazon Corretto 17/OpenJDK 17)
- **Oracle 11g** database
- Network access to Oracle server
- Appropriate Oracle driver (ojdbc8.jar recommended)

## Using MCP Server
```json
{
  "mcpServers": {
    "memory": {
      "command": "java",
      "args": ["-jar", "mcp-server-oracle/target/mcp-server-oracle-0.0.1-SNAPSHOT.jar"]
    }
  }
}
