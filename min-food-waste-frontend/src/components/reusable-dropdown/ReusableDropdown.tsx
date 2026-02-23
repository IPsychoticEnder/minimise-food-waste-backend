import React, { type ReactNode, useEffect, useRef, useState } from 'react'

import './ReusableDropdown.css'

type Props = {
    trigger: ReactNode;
    children: ReactNode;

}

function ReusableDropdown(props: Props) {
    const {
        trigger,
        children
    } = props;

    const [isOpen, setIsOpen] = useState(false);
    const dropdownRef = useRef<HTMLDivElement>(null);

    function toggleDropdown(){
        setIsOpen(!isOpen);
    }

    useEffect(() => {
        function handleClickOutside(event: MouseEvent) {
            if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)){
                setIsOpen(false);
            }
        }
        if (isOpen){
            document.addEventListener('mousedown', handleClickOutside);
        }else {
            document.removeEventListener('mousedown', handleClickOutside);
        }
        console.log('Dropdown isOpen:', isOpen);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        }
    }, [isOpen]);

  return (
    <div className='reusable-dropdown' ref={dropdownRef}>
        <div 
            className='reusable-dropdown-trigger'
            onClick={toggleDropdown}
            role='button'
            tabIndex={0}
            aria-haspopup='true'
            aria-expanded={isOpen}
        >
            {trigger}
        </div>
        {isOpen && (
            <div className='dropdown-content'>
                {children}
            </div>
        )}
    </div>
  )
}

export default ReusableDropdown