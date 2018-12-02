<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/cse310.css"/>'>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" crossorigin="anonymous">
<link href='<spring:url value="/resources/calender/fullcalendar.min.css"/>' rel='stylesheet' />
<link href='<spring:url value="/resources/calender/fullcalendar.print.min.css"/>' rel='stylesheet' media='print' />
<script src='<spring:url value="/resources/calender/moment.min.js"/>'></script>
<script src='<spring:url value="/resources/calender/jquery.min.js"/>'></script>
<script src='<spring:url value="/resources/calender/fullcalendar.min.js"/>'></script>
<script>

  $(document).ready(function() {

    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay'
      },
      defaultDate: '2018-03-12',
      navLinks: true, // can click day/week names to navigate views
 
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: 'All Day Event',
          start: '2018-03-01'
        },
        {
          title: 'Long Event',
          start: '2018-03-07',
          end: '2018-03-10'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2018-03-09T16:00:00'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2018-03-16T16:00:00'
        },
        {
          title: 'Conference',
          start: '2018-03-11',
          end: '2018-03-13'
        },
        {
          title: 'Meeting',
          start: '2018-03-12T10:30:00',
          end: '2018-03-12T12:30:00'
        },
        {
          title: 'Lunch',
          start: '2018-03-12T12:00:00'
        },
        {
          title: 'Meeting',
          start: '2018-03-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          start: '2018-03-12T17:30:00'
        },
        {
          title: 'Dinner',
          start: '2018-03-12T20:00:00'
        },
        {
          title: 'Potato Party',
          start: '2018-03-13T09:00:00'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2018-03-28'
        }
      ]
    });

  });

</script>



<style>

  body {
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
    
  }

  #calendar {
    
    margin: 40px 10px;
    max-width: 800px;
    margin: 0 auto;
    background-color: white;
    float: left
  }

</style>

</head>
<body>
    
    

    <%@include file="header.jsp" %>

    <div id='calendar'>
        
        
    </div>
    <%@include file="footer.jsp" %>

</body>
</html>

