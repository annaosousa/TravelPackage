// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

// Protobuf Java Version: 3.25.5
package com.example;

public interface FlightRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.FlightRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string origin = 1;</code>
   * @return The origin.
   */
  java.lang.String getOrigin();
  /**
   * <code>string origin = 1;</code>
   * @return The bytes for origin.
   */
  com.google.protobuf.ByteString
      getOriginBytes();

  /**
   * <code>string destination = 2;</code>
   * @return The destination.
   */
  java.lang.String getDestination();
  /**
   * <code>string destination = 2;</code>
   * @return The bytes for destination.
   */
  com.google.protobuf.ByteString
      getDestinationBytes();

  /**
   * <code>string date = 3;</code>
   * @return The date.
   */
  java.lang.String getDate();
  /**
   * <code>string date = 3;</code>
   * @return The bytes for date.
   */
  com.google.protobuf.ByteString
      getDateBytes();

  /**
   * <code>int32 num_people = 4;</code>
   * @return The numPeople.
   */
  int getNumPeople();
}
