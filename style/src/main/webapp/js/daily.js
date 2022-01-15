function deleteDaily(n) {
  const ok = confirm("정말 삭제하실 거에요?");

  if (ok) {
    location.href = "DeleteDaily?no=" + n;
  }
}

const like = document.querySelector(".like i");

function pressLike() {
  like.classList.toggle("active");
}

function dailyCommentDelCheck(cno, pno) {
  let ok = confirm("정말 삭제하실 거에요?");

  if (ok) {
    location.href = "DailyCommentDeleteC?cno=" + cno + "&no=" + pno;
  }
}
/**
 *
 */
