function validateAddExamForm() {
    var examName = document.forms["addExam"]["examname"].value;
    var duration = document.forms["addExam"]["duration"].value;
    var totalQuestions = document.forms["addExam"]["TotalQuestions"].value;
    var numbers = /^[0-9]+$/;
    if (examName == null || examName == "" 
        && duration == null || duration == "" 
        && totalQuestions == null || totalQuestions == "") {
        swal({
            title: "Error",
            text: "Please fillout all the fields",
            type: "error"
        });
        return false;
    } else if (examName == null || examName == "") {
        swal({
            title: "Error",
            text: "Exam Name Can't be blank..!!",
            type: "error"
        });
        return false;
    } else if (duration == null || duration == "") {
        swal({
            title: "Error",
            text: "Duration Can't be blank..!!",
            type: "error"
        });
        return false;
    } else if (totalQuestions == null || totalQuestions == "") {
        swal({
            title: "Error",
            text: "Total Questions Can't be blank..!!",
            type: "error"
        });
        return false;
    } else if ((!(examName.match(numbers)))) {
        swal({
            title: "Error",
            text: "Exam Name must be a number..!!",
            type: "error"
        });
        return false
    } else if ((!(duration.match(numbers)))) {
        swal({
            title: "Error",
            text: "Duration must be a number..!!",
            type: "error"
        });
        return false
    } else if ((!(totalQuestions.match(numbers)))) {
        swal({
            title: "Error",
            text: "Total Questions must be a number..!!",
            type: "error"
        });
        return false
    } else if (duration < 1 || totalQuestions < 1) {
        swal({
            title: "Error",
            text: "Kindly provide Number other than ZERO",
            type: "error"
        });
        return false
    }
}

