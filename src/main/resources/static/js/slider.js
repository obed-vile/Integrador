document.addEventListener('DOMContentLoaded', function() {
    const slides = document.querySelectorAll('.slide');
    const slideTexts = document.querySelectorAll('.slide-text');
    const prevBtn = document.querySelector('.prev-btn');
    const nextBtn = document.querySelector('.next-btn');
    const dotsContainer = document.querySelector('.slider-dots');
    
    let currentSlide = 0;
    let isTransitioning = false; // Prevenir múltiples clics durante la transición
    
    // Crear dots
    slides.forEach((_, index) => {
        const dot = document.createElement('div');
        dot.classList.add('dot');
        if (index === 0) dot.classList.add('active');
        dot.addEventListener('click', () => goToSlide(index));
        dotsContainer.appendChild(dot);
    });
    
    const dots = document.querySelectorAll('.dot');
    
    function updateSlides() {
        if (isTransitioning) return;
        isTransitioning = true;
        
        slides.forEach(slide => slide.classList.remove('active'));
        slideTexts.forEach(text => text.classList.remove('active'));
        dots.forEach(dot => dot.classList.remove('active'));
        
        slides[currentSlide].classList.add('active');
        slideTexts[currentSlide].classList.add('active');
        dots[currentSlide].classList.add('active');
        
        // Permitir nueva transición después de completar la actual
        setTimeout(() => {
            isTransitioning = false;
        }, 1000); // Coincide con la duración de la transición CSS
    }
    
    function nextSlide() {
        if (!isTransitioning) {
            currentSlide = (currentSlide + 1) % slides.length;
            updateSlides();
        }
    }
    
    function prevSlide() {
        if (!isTransitioning) {
            currentSlide = (currentSlide - 1 + slides.length) % slides.length;
            updateSlides();
        }
    }
    
    function goToSlide(index) {
        if (!isTransitioning && currentSlide !== index) {
            currentSlide = index;
            updateSlides();
        }
    }
    
    // Event listeners
    prevBtn.addEventListener('click', prevSlide);
    nextBtn.addEventListener('click', nextSlide);
    
    // Auto slide
    let autoSlideInterval = setInterval(nextSlide, 5000);
    
    // Pausar el auto-slide al hover
    const heroSection = document.querySelector('.hero');
    heroSection.addEventListener('mouseenter', () => {
        clearInterval(autoSlideInterval);
    });
    
    heroSection.addEventListener('mouseleave', () => {
        autoSlideInterval = setInterval(nextSlide, 5000);
    });
});