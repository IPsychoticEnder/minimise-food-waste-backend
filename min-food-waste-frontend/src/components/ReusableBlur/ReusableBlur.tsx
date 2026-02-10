import { type ReactNode, useEffect, useRef, useState } from "react";

import './ReusableBlur.css'

type Props = {
    trigger: ReactNode;
    children: ReactNode;
}

function ReusableBlur(props: Props) {
    const {
        trigger,
        children
    } = props;

    const [isOpen, setIsOpen] = useState(false);
    const blurRef = useRef<HTMLHtmlElement>(null);

    function openBlur(){
        setIsOpen(true);
    }

    function closeBlur(){
        setIsOpen(false)
    }

    function handleOverlayClick(event: React.MouseEvent<HTMLDivElement>) {
        if (event.target === event.currentTarget) {
            closeBlur();
        }
    }

    useEffect(() => {
        function handleKeyDown(event: KeyboardEvent){
            if (event.key === 'Escape'){
                closeBlur();
            }
        }

        if (isOpen){
            document.addEventListener('keydown', handleKeyDown);
            document.body.style.overflow = 'hidden'
        }else {
            document.removeEventListener('keydown', handleKeyDown);
            document.body.style.overflow = '';
        }

        return () => {
            document.removeEventListener('keydown', handleKeyDown);
            document.body.style.overflow = '';
        }
    }, [isOpen, onclose]);

  return (
    <>
    {/* The Trigger Element */}
    <div className="reusable-blur-trigger" onClick={openBlur}>
        {trigger}
    </div>

    {/* The Overlay and Content (only rendered when isOpen is true) */}
    {isOpen && (
        // Use React Portal here for better stacking context management if needed,
        // but for simplicity, we'll render directly first.
        <div
            className="reusable-blur-overlay"
            onClick={handleOverlayClick} // Close on overlay click
            role="dialog" // More appropriate role for a modal popup
            aria-modal="true" // Indicates content outside is inert
        >
            <div
                className="reusable-blur-content"
                // Optional: Add aria-labelledby/aria-describedby pointing to title/description inside children
            >
                {/* You might want a close button inside the content too */}
                {/* <button onClick={closeBlur} className="close-button">X</button> */}
                {children}
            </div>
        </div>
    )}
</>
  )
}

export default ReusableBlur