/**
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package ua.iot.lviv.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


/**
 * Recorded
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-27T21:41:25.115+02:00")
public class Recorded   {
  @SerializedName("movieName")
  private String movieName = null;

  @SerializedName("isRecognized")
  private Boolean recognized = null;

  @SerializedName("time")
  private Double time = null;

  public Recorded movieName(String movieName) {
    this.movieName = movieName;
    return this;
  }

   /**
   * Get movieName
   * @return movieName
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public Recorded recognized(Boolean recognized) {
    this.recognized = recognized;
    return this;
  }

   /**
   * Get recognized
   * @return isRecognized
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getRecognized() {
    return recognized;
  }

  public void setRecognized(Boolean recognized) {
    this.recognized = recognized;
  }

  public Recorded time(Double time) {
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(example = "null", value = "")
  public Double getTime() {
    return time;
  }

  public void setTime(Double time) {
    this.time = time;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recorded recorded = (Recorded) o;
    return Objects.equals(this.movieName, recorded.movieName) &&
        Objects.equals(this.recognized, recorded.recognized) &&
        Objects.equals(this.time, recorded.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieName, recognized, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recorded {\n");
    
    sb.append("    movieName: ").append(toIndentedString(movieName)).append("\n");
    sb.append("    recognized: ").append(toIndentedString(recognized)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

