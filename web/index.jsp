<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 03.03.15
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>VK post's likes parser</title>
    <link rel="stylesheet" type="text/css" href="./styles/styles.css">
    <script type="text/javascript" src="scripts/jquery.js"></script>
    <script type="text/javascript" src="scripts/1.js"></script>

</head>
<body>
<div class="container">
    <div class="logo"><h1>PROF.<span>orient</span></h1></div>

    <div class="authBlock">
        <div class="field">
            <span class="hint">Style:</span><br />
            <select id="style">
                <option value="0">Business</option>
                <option value="1">Casual</option>
                <option value="2">Sport</option>
            </select>
        </div>

        <div class="field">
            <span class="hint">Health:</span><br />
            <select id="health">
                <option value="0">Sport</option>
                <option value="1">Normal</option>
                <option value="2">Bad</option>
            </select>
        </div>
        <div class="field">
            <span class="hint">Do you ambitious person?</span><br />
            <select id="ambitions">
                <option value="1">Yes</option>
                <option value="0">No</option>
            </select>
        </div>
        <div class="field">
            <span class="hint">Check you hobbies:</span><br />
            <input type="checkbox" id="computers" value="computers">Computers
            <input type="checkbox" id="psychology" value="psychology">psychology
            <input type="checkbox" id="education_hobbie" value="education">education
        </div>
        <div class="field">
            <span class="hint">Check you education:</span><br />
            <select id="education">
                <option value="0">High+courses</option>
                <option value="1">High</option>
                <option value="2">No education</option>
            </select>
        </div>

        <div class="field">
            <span class="hint">Select your gender:</span><br />
            <select id="gender">
                <option value="0">Male</option>
                <option value="1">Female</option>
            </select>
        </div>
        <div class="field">
            <span class="hint">Enter your age:</span><br />
            <input type="number" id="age">
        </div>
        <div class="field">
            <span class="hint">Do you know foreign languages?</span><br />
            <select id="foreign">
                <option value="1">Yes</option>
                <option value="0">No</option>
            </select>
        </div>
        <div class="field">
            <span class="hint">Enter your IQ</span><br />
            <input type="number" id="iq">
        </div>
        <div class="field">
            <span class="hint">Do you trust in God?</span><br />
            <select id="god">
                <option value="1">Yes</option>
                <option value="0">No</option>
            </select>
        </div>
        <div class="field">
            <span class="hint">Do you involved in politics?</span><br />
            <select id="politics">
                <option value="1">Yes</option>
                <option value="0">No</option>
            </select>
        </div>


        <div class="field">
            <button id="getResult">Get my profession!</button>
        </div>
        <div class="result">
        </div>

    </div>
</div>



</body></html>
