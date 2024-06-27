/*
 * SaaSus Communication API Schema
 * SaaSus Communication API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.communication.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.communication.models.Comment;
import saasus.sdk.communication.models.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import saasus.sdk.communication.JSON;

/**
 * Feedback
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-27T08:20:59.072968840Z[Etc/UTC]")
public class Feedback {
  public static final String SERIALIZED_NAME_FEEDBACK_TITLE = "feedback_title";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_TITLE)
  private String feedbackTitle;

  public static final String SERIALIZED_NAME_FEEDBACK_DESCRIPTION = "feedback_description";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_DESCRIPTION)
  private String feedbackDescription;

  public static final String SERIALIZED_NAME_COMMENTS = "comments";
  @SerializedName(SERIALIZED_NAME_COMMENTS)
  private List<Comment> comments = new ArrayList<>();

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public static final String SERIALIZED_NAME_USERS = "users";
  @SerializedName(SERIALIZED_NAME_USERS)
  private List<User> users = new ArrayList<>();

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_USER_ID = "user_id";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private String userId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private Integer createdAt;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private Integer status;

  public Feedback() {
  }

  public Feedback feedbackTitle(String feedbackTitle) {
    this.feedbackTitle = feedbackTitle;
    return this;
  }

   /**
   * Get feedbackTitle
   * @return feedbackTitle
  **/
  @javax.annotation.Nonnull
  public String getFeedbackTitle() {
    return feedbackTitle;
  }

  public void setFeedbackTitle(String feedbackTitle) {
    this.feedbackTitle = feedbackTitle;
  }


  public Feedback feedbackDescription(String feedbackDescription) {
    this.feedbackDescription = feedbackDescription;
    return this;
  }

   /**
   * Get feedbackDescription
   * @return feedbackDescription
  **/
  @javax.annotation.Nonnull
  public String getFeedbackDescription() {
    return feedbackDescription;
  }

  public void setFeedbackDescription(String feedbackDescription) {
    this.feedbackDescription = feedbackDescription;
  }


  public Feedback comments(List<Comment> comments) {
    this.comments = comments;
    return this;
  }

  public Feedback addCommentsItem(Comment commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<>();
    }
    this.comments.add(commentsItem);
    return this;
  }

   /**
   * Get comments
   * @return comments
  **/
  @javax.annotation.Nonnull
  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }


  public Feedback count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @javax.annotation.Nonnull
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  public Feedback users(List<User> users) {
    this.users = users;
    return this;
  }

  public Feedback addUsersItem(User usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @javax.annotation.Nonnull
  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


  public Feedback id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Feedback userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @javax.annotation.Nonnull
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public Feedback createdAt(Integer createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nonnull
  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }


  public Feedback status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feedback feedback = (Feedback) o;
    return Objects.equals(this.feedbackTitle, feedback.feedbackTitle) &&
        Objects.equals(this.feedbackDescription, feedback.feedbackDescription) &&
        Objects.equals(this.comments, feedback.comments) &&
        Objects.equals(this.count, feedback.count) &&
        Objects.equals(this.users, feedback.users) &&
        Objects.equals(this.id, feedback.id) &&
        Objects.equals(this.userId, feedback.userId) &&
        Objects.equals(this.createdAt, feedback.createdAt) &&
        Objects.equals(this.status, feedback.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feedbackTitle, feedbackDescription, comments, count, users, id, userId, createdAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feedback {\n");
    sb.append("    feedbackTitle: ").append(toIndentedString(feedbackTitle)).append("\n");
    sb.append("    feedbackDescription: ").append(toIndentedString(feedbackDescription)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("feedback_title");
    openapiFields.add("feedback_description");
    openapiFields.add("comments");
    openapiFields.add("count");
    openapiFields.add("users");
    openapiFields.add("id");
    openapiFields.add("user_id");
    openapiFields.add("created_at");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("feedback_title");
    openapiRequiredFields.add("feedback_description");
    openapiRequiredFields.add("comments");
    openapiRequiredFields.add("count");
    openapiRequiredFields.add("users");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("user_id");
    openapiRequiredFields.add("created_at");
    openapiRequiredFields.add("status");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Feedback
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Feedback.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Feedback is not found in the empty JSON string", Feedback.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Feedback.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Feedback` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Feedback.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("feedback_title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `feedback_title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("feedback_title").toString()));
      }
      if (!jsonObj.get("feedback_description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `feedback_description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("feedback_description").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("comments").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `comments` to be an array in the JSON string but got `%s`", jsonObj.get("comments").toString()));
      }

      JsonArray jsonArraycomments = jsonObj.getAsJsonArray("comments");
      // validate the required field `comments` (array)
      for (int i = 0; i < jsonArraycomments.size(); i++) {
        Comment.validateJsonElement(jsonArraycomments.get(i));
      };
      // ensure the json data is an array
      if (!jsonObj.get("users").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `users` to be an array in the JSON string but got `%s`", jsonObj.get("users").toString()));
      }

      JsonArray jsonArrayusers = jsonObj.getAsJsonArray("users");
      // validate the required field `users` (array)
      for (int i = 0; i < jsonArrayusers.size(); i++) {
        User.validateJsonElement(jsonArrayusers.get(i));
      };
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("user_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Feedback.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Feedback' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Feedback> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Feedback.class));

       return (TypeAdapter<T>) new TypeAdapter<Feedback>() {
           @Override
           public void write(JsonWriter out, Feedback value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Feedback read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Feedback given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Feedback
  * @throws IOException if the JSON string is invalid with respect to Feedback
  */
  public static Feedback fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Feedback.class);
  }

 /**
  * Convert an instance of Feedback to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

