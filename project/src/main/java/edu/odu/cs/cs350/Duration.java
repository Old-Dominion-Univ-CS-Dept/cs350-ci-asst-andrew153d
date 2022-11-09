
package edu.odu.cs.cs350;
import java.util.Arrays;


/**
 * A duration represents a period of elapsed time, e.g., 4 hours, 23 minutes, 2 seconds.
 * This is differentiated from a point in time (e.g., 4:23:02AM). A meeting that
 * has a duration of 2 hours has that same duration no matter where it was held. A 
 * starting time (point) for that of 2:00PM EST can be unambiguous only if the time
 * zone is added.
 * 
 * <p>
 * Because durations are often used in calculations, both positive and
 * negative values are possible.
 * 
 * <p>
 * Most of the accessor functions for this class will respond with normalized
 * values, where the normalization rules are as follows:
 * <ul>
 *   <li>The seconds and minutes components will have an absolute
 *       value in the range 0..59, inclusive.</li> 
 *   <li>The hours component will have an absolute value in the 
 *       range 0..23, inclusive.</li>
 *   <li>The sign of each component matches the sign of the 
 *       overall duration.  A duration of -61 seconds, for example,
 *       has normalized components of -1 seconds and -1 minutes.</li>
 * </ul>
 * Inputs to the member functions are not, however, required to 
 * be normalized. new Duration(0,0,3,-61) and new Duration(0,0,1,59)
 * are both acceptable (and the resulting Duration objects are equal).  
 * 
 * @author zeil
 *
 */
public class Duration implements Cloneable {

  /**
   * Total number of seconds in this duration.
   */
  private long totalSeconds;

  /**
   * Construct a new duration, equivalent to
   * Duration(0,0,0,0).
   */
  public Duration() {
    totalSeconds = 0;
  }

  /**
   * Create a new duration.
   * 
   * @param totalSeconds total number of seconds in duration
   */
  public Duration(long totalSeconds) {
    this.totalSeconds = totalSeconds;
  }

  /**
   * Create a new duration.
   * 
   * @param days  number of days in duration
   * @param hours number of hours in duration
   * @param minutes number of minutes in duration
   * @param seconds number of seconds in duration
   */
  public Duration(int days, int hours, int minutes, int seconds) {
    totalSeconds = seconds + 60 * (minutes + 60 * (hours + 24 * days));
  }

  
  /**
   * Get the total seconds of this duration, including the contributions
   * of the days, hours, minutes, & seconds components.
   *  
   * @return the total seconds
   */
  public long getTotalSeconds() {
    return totalSeconds;
  }

  /**
   * Set the total seconds of this duration, potentially altering
   * the days, hours, minutes, & seconds components.

   * @param totalSeconds the total seconds to set
   */
  public void setTotalSeconds(long totalSeconds) {
    this.totalSeconds = totalSeconds;
  }

  private static final long secondsPerDay = 24 * 60 * 60; 
  
  /**
   * How many days in this duration?.
   * 
   * @return the normalized days component
   */
  public int getDays() {
    return (int)(totalSeconds / secondsPerDay);
  }
  
  private static final long secondsPerHour = 60 * 60; 

  /**
   * How many hours in this duration?.
   * 
   * @return the normalized hours component
   */
  public int getHours() {
    return (int)((totalSeconds % secondsPerDay) / secondsPerHour);
  }

  
  private static final long secondsPerMinute = 60; 

  /**
   * How many minutes in this duration?.
   * 
   * @return the normalized minutes component
   */
  public int getMinutes() {
    return (int)((totalSeconds % secondsPerHour) / secondsPerMinute);
  }
  

  /**
   * How many seconds in this duration?.
   * 
   * @return the normalized seconds component
   */
  public int getSeconds() {
    return (int)(totalSeconds % secondsPerMinute);
  }

  /**
   * Add another duration to this one.
   * @param dur a duration
   */
  public void add(Duration dur) {
    totalSeconds += dur.totalSeconds;
  }

  /**
   * Subtract another duration from this one.
   * @param dur a duration
   */
  public void subtract(Duration dur) {
    totalSeconds -= dur.totalSeconds;
  }

  /**
   * Multiply this duration by a scaling factor,
   * rounding to the closest second.
   * @param factor a scaling factor
   */
  public void scale(double factor) {
    double sec = factor * (double)totalSeconds;
    totalSeconds = Math.round(sec);
  }

  /**
   * Render the duration as
   *     d:h:m:s
   * (preceded by a '-'if the duration is negative)
   * where the four components are normalized non-negative
   * integer values. The final three components are always rendered 
   * in 2 digits. The two leading components and their 
   * associated ':' delimiters are omitted if the leading values
   * are zero.  E.g., Duration(0,-1,-59,-61) would be rendered as
   * "-2:00:01".
   */
  public String toString() {
    StringBuffer buf = new StringBuffer();
    long secs = totalSeconds;
    if (secs < 0) {
      secs = -secs;
      buf.append('-');
    }
    boolean leading = true;
    long days = secs / secondsPerDay; 
    if (days > 0) {
      buf.append(days);
      buf.append(':');
      secs = secs % secondsPerDay;
      leading = false;
    }
    
    long hours = secs / secondsPerHour; 
    if (hours > 0 || ((!leading) && (hours == 0))) {
      if (hours < 10) {
        buf.append('0');
      }
      buf.append(hours);
      buf.append(':');
      secs = secs % secondsPerHour;
      leading = false;
    }
    
    long minutes = secs / secondsPerMinute; 
    if (minutes < 10) {
      buf.append('0');
    }
    buf.append(minutes);
    buf.append(':');
    secs = secs % secondsPerMinute;
    leading = false;

    if (secs < 10) {
      buf.append('0');
    }
    buf.append(secs);
    
    
    return buf.toString();
  }
  
  

  // Comparison and hashing

  /**
   * Compares two durations for equality. They are considered equal if
   * their getTotalSeconds() values are equal.
   *
   * @param obj object to be compared for equality with this duration
   * @return <tt>true</tt> if the specified object is equal to this one
   */
  public boolean equals(Object obj) {
    if (!(obj instanceof Duration)) {
      return false;
    }
    Duration other = (Duration)obj;
    return totalSeconds == other.totalSeconds;
  }

  /**
   * Returns the hash code value for this object.
   *
   * @return the hash code value for this duration
   */
  public int hashCode() {
    return (int)totalSeconds;
  }

  /**
   * Return a (deep) copy of this object.
   */
  @Override
  public Object clone()  {
    Duration theClone = new Duration(totalSeconds);
    return theClone;
  }


}
