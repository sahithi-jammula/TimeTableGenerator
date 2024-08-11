setTimeout(function() {
    document.getElementById('logo').classList.add('hidden');
    document.getElementById('roleSelection').style.display = 'flex';
}, 3000);

document.getElementById('admin').addEventListener('click', function() {
    window.location.href = 'adminlogin.jsf';
});

document.getElementById('user').addEventListener('click', function() {
    window.location.href = 'facultylogin.jsf';
});
